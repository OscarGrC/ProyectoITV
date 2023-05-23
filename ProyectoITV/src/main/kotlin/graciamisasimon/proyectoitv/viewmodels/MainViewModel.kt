package graciamisasimon.proyectoitv.viewmodels

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.repositories.ITVRepository
import graciamisasimon.proyectoitv.routes.RoutesManager
import graciamisasimon.proyectoitv.services.storage.StorageITV
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.image.Image
import mu.KotlinLogging
import java.io.File
import java.time.LocalDate

class MainViewModel(
    private val repository: ITVRepository,
    private val storage: StorageITV
) {
    private val logger = KotlinLogging.logger {  }
    // Estado del ViewModel
    val state = SimpleObjectProperty(MainState())

    init {
        logger.debug { "Inicializando ExpedientesViewModel" }
        loadCitasFromRepository() // Cargamos los datos del repositorio
        loadTypes() // Cargamos los tipos de busqueda
    }

    private fun loadTypes() {
        logger.debug { "Cargando tipos de busqueda" }
        state.value = state.value.copy(
            typesTipo = listOf(
                TipoFiltro.TODOS.value,
                TipoFiltro.TIPO.value,
                TipoFiltro.DNI.value,
                TipoFiltro.MOTOR.value
            )
        )
    }

    private fun loadCitasFromRepository() {
        logger.debug { "Cargando citas del repositorio" }
        val lista = repository.findAllCita()
        logger.debug { "Cargando citas del repositorio: ${lista.size}" }
        updateState(lista)
    }

    // Actualiza el estado de la aplicación con los datos de ese instante en el estado
    private fun updateState(listaAlumnos: List<Vehiculo>) {
        logger.debug { "Actualizando estado de Aplicacion" }

        val vehiculoSeleccionado =MainFormulario()

        state.value = state.value.copy(
            alumnos = listaAlumnos.sortedBy { it.apellidos }, // Ordenamos por apellidos
            numAprobados = numAprobados,
            notaMedia = notaMedia,
            alumnoSeleccionado = vehiculoSeleccionado
        )
    }

    // Filtra la lista de alumnnos en el estado en función del tipo y el nombre completo
    fun alumnosFilteredList(tipo: String, nombreCompleto: String): List<Alumno> {
        logger.debug { "Filtrando lista de Alumnos: $tipo, $nombreCompleto" }

        return state.value.alumnos
            .filter { alumno ->
                when (tipo) {
                    TipoFiltro.SI.value -> alumno.repetidor
                    TipoFiltro.NO.value -> !alumno.repetidor
                    else -> true
                }
            }.filter { alumno ->
                alumno.nombreCompleto.contains(nombreCompleto, true)
            }

    }

    fun saveAlumnadoToJson(file: File): Result<Long, AlumnoError> {
        logger.debug { "Guardando Alumnado en JSON" }
        return storage.storeDataJson(file, state.value.alumnos)
    }

    fun loadAlumnadoFromJson(file: File, withImages: Boolean = false): Result<List<Alumno>, AlumnoError> {
        logger.debug { "Cargando Alumnado en JSON" }
        // Borramos todas las imagenes e iniciamos el proceso
        return storage.deleteAllImages().andThen {
            storage.loadDataJson(file).onSuccess {
                repository.deleteAll() // Borramos todos los datos de la BD
                // Guardamos los nuevos, pero hay que quitarle el ID, porque trabajamos con el NEW!!
                repository.saveAll(
                    if (withImages)
                        it
                    else
                        it.map { a -> a.copy(id = Alumno.NEW_ALUMNO, imagen = TipoImagen.SIN_IMAGEN.value) }
                )
                loadAlumnosFromRepository() // Actualizamos la lista
            }
        }
    }

    // carga en el estado el alumno seleccionado
    fun updateAlumnoSeleccionado(alumno: Alumno) {
        logger.debug { "Actualizando estado de Alumno: $alumno" }

        lateinit var fileImage: File
        lateinit var imagen: Image

        storage.loadImage(alumno.imagen).onSuccess {
            imagen = Image(it.absoluteFile.toURI().toString())
            fileImage = it
        }.onFailure {
            imagen = Image(RoutesManager.getResourceAsStream(SIN_IMAGEN))
            fileImage = File(RoutesManager.getResource(SIN_IMAGEN).toURI())
        }

        val alumnoSeleccionado = AlumnoFormulario(
            numero = alumno.id,
            apellidos = alumno.apellidos,
            nombre = alumno.nombre,
            email = alumno.email,
            fechaNacimiento = alumno.fechaNacimiento,
            calificacion = alumno.calificacion,
            repetidor = alumno.repetidor,
            fileImage = fileImage,
            imagen = imagen
        )

        state.value = state.value.copy(alumnoSeleccionado = alumnoSeleccionado)
    }


    // Crea un nuevo alumno en el estado y repositorio
    fun crearAlumno(alumnoNuevo: AlumnoFormulario): Result<Alumno, AlumnoError> {
        logger.debug { "Creando Alumno" }
        // creamos el alumno
        println("Alumno a crear: $alumnoNuevo")
        var newAlumno = alumnoNuevo.toModel().copy(id = Alumno.NEW_ALUMNO)
        return newAlumno.validate()
            .andThen {
                // Copiamos la imagen si no es nula
                println("Imagen a copiar: ${alumnoNuevo.fileImage}")
                alumnoNuevo.fileImage?.let { newFileImage ->
                    storage.saveImage(newFileImage).onSuccess {
                        kotlin.io.println("Imagen copiada: ${it.name}")
                        newAlumno = newAlumno.copy(imagen = it.name)
                    }
                }
                val new = repository.save(newAlumno)
                // Actualizamos la lista
                // Podriamos cargar del repositorio otra vez, si fuera concurente o
                // conectada a un servidor remoto debería hacerlo así
                updateState(state.value.alumnos + new)
                Ok(new)
            }
    }

    // Edita un alumno en el estado y repositorio
    fun editarAlumno(alumnoEditado: AlumnoFormulario): Result<Alumno, AlumnoError> {
        logger.debug { "Editando Alumno" }
        // creamos el alumno
        val fileImageTemp = state.value.alumnoSeleccionado.fileImage // Nombre de la imagen que tiene
        var updatedAlumno = alumnoEditado.toModel().copy(imagen = fileImageTemp!!.name)
        return updatedAlumno.validate()
            .andThen {
                // Tenemos dos opciones, que no tuviese imagen o que si la tuviese
                alumnoEditado.fileImage?.let { newFileImage ->
                    if (updatedAlumno.imagen == TipoImagen.SIN_IMAGEN.value || updatedAlumno.imagen == TipoImagen.EMPTY.value) {
                        storage.saveImage(newFileImage).onSuccess {
                            updatedAlumno = updatedAlumno.copy(imagen = it.name)
                        }
                    } else {
                        storage.updateImage(fileImageTemp, newFileImage)
                    }
                }
                val updated = repository.save(updatedAlumno)
                // Actualizamos la lista
                // Podriamos cargar del repositorio otra vez, si fuera concurente o
                // conectada a un servidor remoto debería hacerlo así
                //val lista = state.value.alumnos.toMutableList()
                //val indexedValue = lista.indexOfFirst { a -> a.id == updated.id }
                //lista[indexedValue] = updated
                // updateState(lista)
                updateState(
                    state.value.alumnos.filter { it.id != updated.id } + updated
                )
                Ok(updated)
            }
    }

    // Elimina un alumno en el estado y repositorio
    fun eliminarAlumno(): Result<Unit, AlumnoError> {
        logger.debug { "Eliminando Alumno" }
        // Hay que eliminar su imagen, primero siempre una copia!!!
        val alumno = state.value.alumnoSeleccionado.copy()
        // Para evitar que cambien en la selección!!!

        alumno.fileImage?.let {
            if (it.name != TipoImagen.SIN_IMAGEN.value) {
                storage.deleteImage(it)
            }
        }

        // Borramos del repositorio
        repository.deleteById(alumno.numero)
        // Actualizamos la lista
        // Podriamos cargar del repositorio otra vez, si fuera concurente o
        // conectada a un servidor remoto debería hacerlo así
        updateState(state.value.alumnos.filter { it.id != alumno.numero })
        return Ok(Unit)
    }

    fun exportToZip(fileToZip: File): Result<Unit, AlumnoError> {
        logger.debug { "Exportando a ZIP: $fileToZip" }
        // recogemos los alumnos del repositorio
        val alumnos = repository.findAll()
        storage.exportToZip(fileToZip, alumnos)
        return Ok(Unit)
    }

    fun loadAlumnadoFromZip(fileToUnzip: File): Result<List<Alumno>, AlumnoError> {
        logger.debug { "Importando de ZIP: $fileToUnzip" }
        // recogemos los alumnos del repositorio
        return storage.loadFromZip(fileToUnzip).onSuccess { it ->
            repository.deleteAll()
            repository.saveAll(it.map { a -> a.copy(id = Alumno.NEW_ALUMNO) })
            loadCitasFromRepository()
        }
    }

    fun setTipoOperacion(tipo: TipoOperacion) {
        logger.debug { "Cambiando tipo de operación: $tipo" }
        state.value = state.value.copy(tipoOperacion = tipo)
    }

    fun getDefautltImage(): Image {
        return Image(RoutesManager.getResourceAsStream("images/notFound.png"))
    }

    // Clases que representan el estado
    // Estado del ViewModel y caso de uso de Gestión de Expedientes
    data class MainState(
        // Los contenedores de colecciones deben ser ObservableList
        val typesTipo: List<String> = listOf(),
        val typesMotor: List<String> = listOf(),
        val typesMarca: List<String> = listOf(),
        val listaCombo: List<String> = listOf(" ","TipoVehiculo",("TipoMotor"),("DNI"),)

        val vehiculos: List<Vehiculo> = listOf(),
        val citas: List<Cita> = listOf(),

        // siempre que cambia el tipo de operacion, se actualiza
        val vehiculoTablaSeleccionado: MainFormulario = MainFormulario(), // Vehiculo seleccionado en tabla
        val tipoOperacion: TipoOperacion = TipoOperacion.NUEVO // Tipo de operacion
    )
    // Enums
    enum class TipoFiltro(val value: String) {
        TODOS("Todos/as"), TIPO("TipoVehiculo"), MOTOR("Motor"),DNI("DNI")
    }
    enum class TipoOperacion(val value: String) {
        NUEVO("Nuevo"), EDITAR("Editar")
    }
    enum class TipoImagen(val value: String) {
        NOT_FOUND("images/notFound.png"), EMPTY("")
    }
    // Estado para formularios de Alumno (seleccionado y de operaciones)
    data class MainFormulario(
        val matricula: String = "",
        val marca: String = "",
        val modelo: String = "",
        val fechaMatriculacion: LocalDate = LocalDate.now(),
        val tipoVehiculo: String = "",
        val tipoMotor: String = "",
        val clienteNombre:String = "",
        val clienteCorreo:String = "",
        val clienteDNI:String = "",
        val clienteTelefono:String = "",
        val imagen: Image = Image(RoutesManager.getResourceAsStream("images/notFound")),
        var fileImage: File? = null
    )
}