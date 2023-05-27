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
    TODO()
    }

    // Filtra la lista de alumnnos en el estado en función del tipo y el nombre completo
    fun VehiculosFilteredList(tipo: String, nombreCompleto: String): List<Vehiculo> {
        logger.debug { "Filtrando lista de Vehiculos: $tipo, $nombreCompleto" }

    TODO()
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
    TODO()
    }


    // Crea un nueva cita en el estado y repositorio
    fun crearCita(citaNueva: MainFormulario): Result<Cita, VehiculosError> {
        TODO()
    }

    // Edita un alumno en el estado y repositorio

    // Elimina un alumno en el estado y repositorio
    fun eliminarCita(): Result<Unit, VehiculosError> {
     TODO()
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