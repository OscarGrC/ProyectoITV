package graciamisasimon.proyectoitv.viewmodels

import com.github.michaelbull.result.*
import graciamisasimon.proyectoitv.errors.VehiculosError
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
    private fun updateState(listaCitas: List<Cita>) {
        logger.debug { "Actualizando estado de Aplicacion" }

        val vehiculoSeleccionado =MainFormulario()

        state.value = state.value.copy(
            vehiculos = listaCitas.sortedBy { it.fechaCita }, // Ordenamos por apellidos
            alumnoSeleccionado = vehiculoSeleccionado
        )
    }

    // Filtra la lista de alumnnos en el estado en función del tipo y el nombre completo
    fun VehiculosFilteredList(tipo: String, nombreCompleto: String): List<Vehiculo> {
        logger.debug { "Filtrando lista de Vehiculos: $tipo, $nombreCompleto" }

        return state.value.vehiculos
            .filter { vehiculo ->
                when (tipo) {
                    TipoFiltro .SI.value -> alumno.repetidor
                    TipoFiltro.NO.value -> !alumno.repetidor
                    else -> true
                }
            }.filter { alumno ->
                alumno.nombreCompleto.contains(nombreCompleto, true)
            }

    }

    fun saveCitasToJson(file: File): Result<Long,VehiculosError> {
        logger.debug { "Guardando Alumnado en JSON" }
        return storage.storeDataJsonCita(file, state.value.citas)
    }

    fun loadCitasFromJson(file: File, withImages: Boolean = false): Result<List<Cita>, VehiculosError> {
        logger.debug { "Cargando Alumnado en JSON" }
        // Borramos todas las imagenes e iniciamos el proceso
        return storage.deleteAllImages().andThen {
            storage.loadDataJsonCita(file).onSuccess {
                repository.deleteAllCita() // Borramos todos los datos de la BD
                // Guardamos los nuevos, pero hay que quitarle el ID, porque trabajamos con el NEW!!
                repository.saveAllCitas(it)
                loadCitasFromRepository() // Actualizamos la lista
            }
        }
    }

    // carga en el estado el alumno seleccionado
    fun updateVehiculoSeleccionado(vehiculo: Vehiculo) {
        logger.debug { "Actualizando estado de vehiculo: $vehiculo" }

        lateinit var fileImage: File
        lateinit var imagen: Image

        storage.loadImage(vehiculo.imagen).onSuccess {
            imagen = Image(it.absoluteFile.toURI().toString())
            fileImage = it
        }.onFailure {
            imagen = Image(RoutesManager.getResourceAsStream("images/notFound.png"))
            fileImage = File(RoutesManager.getResource("images/notFound.png").toURI())
        }

        val vehiculoSeleccionado = MainFormulario(
          matricula  = vehiculo.matricula,
          marca = vehiculo.marca,
          modelo = vehiculo.modelo,
          fechaMatriculacion = vehiculo.fechaMatriculacion,
          tipoVehiculo  = vehiculo.tipoVehiculo.name,
          tipoMotor  = vehiculo.tipoMotor.name,
          clienteNombre  = vehiculo.propietario.nombre,
          clienteCorreo  = vehiculo.propietario.correoCliente,
          clienteDNI  = vehiculo.propietario.dni,
          clienteTelefono  = vehiculo.propietario.telefonoCliente.toString(),
          fileImage = fileImage,
          imagen = imagen
        )

        state.value = state.value.copy(vehiculoTablaSeleccionado = vehiculoSeleccionado)
    }


    // Crea un nueva cita en el estado y repositorio
    fun crearCita(citaNueva: MainFormulario): Result<Cita, VehiculosError> {
        logger.debug { "Creando Cita" }
        // creamos la cita
        println("cita a crear: $citaNueva")
        var newCita = citaNueva.toModel().copy(id = Alumno.NEW_ALUMNO)
        return newCita.validate()
            .andThen {
                // Copiamos la imagen si no es nula
                println("Imagen a copiar: ${citaNueva.fileImage}")
                citaNueva.fileImage?.let { newFileImage ->
                    storage.saveImage(newFileImage).onSuccess {
                        kotlin.io.println("Imagen copiada: ${it.name}")
                        newCita = newCita.copy(imagen = it.name)
                    }
                }
                val new = repository.save(newCita)
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
    fun eliminarCita(): Result<Unit, VehiculosError> {
        logger.debug { "Eliminando Cita" }
        // Hay que eliminar su imagen, primero siempre una copia!!!
        val cita = state.value.vehiculoTablaSeleccionado.copy()
        // Para evitar que cambien en la selección!!!

        cita.fileImage?.let {
            if (it.name != "images/notFound.png") {
                storage.deleteImage(it)
            }
        }

        // Borramos del repositorio
        repository.deleteCita(cita.toCita())
        // Actualizamos la lista
        // Podriamos cargar del repositorio otra vez, si fuera concurente o
        // conectada a un servidor remoto debería hacerlo así
        updateState(state.value.citas.filter { it != cita.toCita() })
        return Ok(Unit)
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
        val listaCombo: List<String> = listOf(" ","TipoVehiculo","TipoMotor","DNI"),
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
        val clienteApellidos:String = "",
        val clienteDNI:String = "",
        val clienteTelefono:String = "",
        val imagen: Image = Image(RoutesManager.getResourceAsStream("images/notFound")),
        var fileImage: File? = null
    )
}