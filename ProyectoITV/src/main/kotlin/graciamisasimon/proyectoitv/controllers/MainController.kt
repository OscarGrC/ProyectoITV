package graciamisasimon.proyectoitv.controllers

import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.models.enums.TipoMotor
import graciamisasimon.proyectoitv.models.enums.TipoVehiculo
import graciamisasimon.proyectoitv.routes.RoutesManager
import graciamisasimon.proyectoitv.viewmodels.MainViewModel
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.Cursor
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.FileChooser
import mu.KotlinLogging
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File

class MainController  : KoinComponent {
    private val logger = KotlinLogging.logger { }

    // Inyectamos nuestro ViewModel
    val viewModel: MainViewModel by inject()

    // Menus
    @FXML
    private lateinit var menuImportar: MenuItem

    @FXML
    private lateinit var menuExportar: MenuItem

    @FXML
    private lateinit var menuZip: MenuItem

    @FXML
    private lateinit var menuUnzip: MenuItem

    @FXML
    private lateinit var menuSalir: MenuItem

    @FXML
    private lateinit var menuAcercaDe: MenuItem

    //la barra del buscador
    @FXML
    private lateinit var textBuscador: TextField

    //Combo
    @FXML
    private lateinit var comboTipo: ComboBox<String>

    // Tabla
    @FXML
    private lateinit var tableVehiculos: TableView<Vehiculo>

    @FXML
    private lateinit var tablaColumnaMatricula: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tableColumnaMarca: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tableColumnaModelo: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tableColumnaTipoMotor: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tablaColumnaTipoVehiculo: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tablaColumnaLastRevision: TableColumn<Vehiculo, String>

    @FXML
    private lateinit var tablaColumaDNI: TableColumn<Vehiculo, String>

    // campos vehiculo
    @FXML
    private lateinit var fieldMatricula: TextField

    @FXML
    private lateinit var fieldMarca: TextField

    @FXML
    private lateinit var fieldModelo: TextField

    @FXML
    private lateinit var dateMatriculacion: DatePicker

    @FXML
    private lateinit var choiceVehiculo: ChoiceBox<TipoVehiculo>

    @FXML
    private lateinit var choiceMotor: ChoiceBox<TipoMotor>

    // campos Cliente
    @FXML
    private lateinit var fieldCLienteNombre: TextField

    @FXML
    private lateinit var fieldCLienteCorreo: TextField

    @FXML
    private lateinit var fieldCLienteDNI: TextField

    @FXML
    private lateinit var fieldCLienteTelefono: TextField

    ////
    @FXML
    private lateinit var tableCitas: TableView<Cita>

    @FXML
    private lateinit var tablaCitaColumnaMatricula: TableColumn<Cita, String>

    @FXML
    private lateinit var tablaCitaColumnaFecha: TableColumn<Cita, String>

    @FXML
    private lateinit var tablaCitaColumnaHora: TableColumn<Cita, String>

    @FXML
    private lateinit var tablaCitaColumnaTecnico: TableColumn<Cita, String>

    // Botones
    @FXML
    private lateinit var botonGenerarInforme: Button

    @FXML
    private lateinit var botonVer: Button

    @FXML
    private lateinit var botonEditar: Button

    @FXML
    private lateinit var botonEliminar: Button
    @FXML
    private lateinit var botonCrear: Button

    // imagen
    @FXML
    private lateinit var imagenVehiculo: ImageView
    private var imageFileVehiculo: File? = null

    @FXML
    fun initialize() {
        logger.debug { "Inicializando MainController FXML" }
        // Iniciamos los bindings
        initBindings()
        // Iniciamos los eventos
        initEventos()
    }


    private fun actuacionSobreImagen() {
        logger.debug { "actuacionSobreImagen" }
        FileChooser().run {
            title = "Selecciona una imagen"
            extensionFilters.addAll(FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg", "*.jpeg"))
            showOpenDialog(RoutesManager.activeStage)
        }?.let {
            imagenVehiculo.image = Image(it.toURI().toString())
            imageFileVehiculo = it
        }

    }

    private fun initBindings() {
        logger.debug { "Inicializando bindings" }
        // comboBoxe
        comboTipo.items = FXCollections.observableArrayList(viewModel.state.value.listaCombo)
        comboTipo.selectionModel.selectFirst()

        // Tablas
        tableVehiculos.items = FXCollections.observableArrayList(viewModel.state.value.vehiculos)
        tableVehiculos.selectionModel.selectionMode = SelectionMode.SINGLE

        tableCitas.items = FXCollections.observableArrayList(viewModel.state.value.citas)
        tableCitas.selectionModel.selectionMode = SelectionMode.SINGLE
        // columnas, con el nombre de la propiedad del objeto hará binding
        tableColumnaMarca.cellValueFactory = PropertyValueFactory("marca")
        tableColumnaModelo.cellValueFactory = PropertyValueFactory("modelo")
        tableColumnaTipoMotor.cellValueFactory = PropertyValueFactory("tipoMotor")
        tablaColumnaTipoVehiculo.cellValueFactory = PropertyValueFactory("tipoVehiculo")
        tablaColumnaLastRevision.cellValueFactory = PropertyValueFactory("lastRevision")
        tablaColumaDNI.cellValueFactory = PropertyValueFactory("dni")

        tablaCitaColumnaMatricula.cellValueFactory = PropertyValueFactory("matricula")
        tablaCitaColumnaFecha.cellValueFactory = PropertyValueFactory("fecha")
        tablaCitaColumnaHora.cellValueFactory = PropertyValueFactory("hora")
        tablaCitaColumnaTecnico.cellValueFactory = PropertyValueFactory("usuario")


        viewModel.state.addListener { _, oldState, newState ->
            updatesFormularioVehiculo(oldState, newState)
            updatesTablaVehiculo(newState, oldState)
            updatesTablaCita(newState, oldState)
        }
    }

    private fun updatesTablaVehiculo(
        newState: MainViewModel.MainState,
        oldState: MainViewModel.MainState
    ) {
        if (newState.vehiculos != oldState.vehiculos) {
            tableVehiculos.selectionModel.clearSelection()
            tableVehiculos.items = FXCollections.observableArrayList(viewModel.state.value.vehiculos)
        }
    }

    private fun updatesTablaCita(
        oldState: MainViewModel.MainState,
        newState: MainViewModel.MainState
    ) {
        TODO()
    }

    private fun updatesFormularioVehiculo(
        oldState: MainViewModel.MainState,
        newState: MainViewModel.MainState
    ) {
        if (oldState.vehiculoTablaSeleccionado != newState.vehiculoTablaSeleccionado) {
            fieldMatricula.text = newState.vehiculoTablaSeleccionado.matricula
            fieldMarca.text = newState.vehiculoTablaSeleccionado.marca
            fieldModelo.text = newState.vehiculoTablaSeleccionado.modelo
            dateMatriculacion.value = newState.vehiculoTablaSeleccionado.fechaMatriculacion
            fieldCLienteNombre.text = newState.vehiculoTablaSeleccionado.clienteNombre
            fieldCLienteCorreo.text = newState.vehiculoTablaSeleccionado.clienteCorreo
            fieldCLienteDNI.text = newState.vehiculoTablaSeleccionado.clienteDNI
            fieldCLienteTelefono.text = newState.vehiculoTablaSeleccionado.clienteTelefono
            choiceVehiculo.value = TipoVehiculo.valueOf(newState.vehiculoTablaSeleccionado.tipoVehiculo)
            choiceMotor.value = TipoMotor.valueOf(newState.vehiculoTablaSeleccionado.tipoMotor)
            imagenVehiculo.image = newState.vehiculoTablaSeleccionado.imagen
        }
    }

    private fun initEventos() {
        logger.debug { "Inicializando eventos" }

        // menús
        menuImportar.setOnAction {
            onImportarAction()
        }

        menuExportar.setOnAction {
            onExportarAction()
        }

        menuSalir.setOnAction {
            onOnCloseAction()
        }

        menuAcercaDe.setOnAction {
            onAcercaDeAction()
        }

        // Botones
        botonCrear.setOnAction {
            onNuevoAction()
        }

        botonEditar.setOnAction {
            onEditarAction()
        }

        botonEliminar.setOnAction {
            onEliminarAction()
        }
        botonVer.setOnAction {
            onVerAction()
        }
        botonGenerarInforme.setOnAction {
            onInformeAction()
        }

        // Combo
        comboTipo.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            newValue?.let { onComboSelected(it) }
        }

        // Tabla
        tableVehiculos.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            newValue?.let { onTablaSelected(it) }
        }

        // Buscador
        // Evento del buscador key press
        // Funciona con el intro
        // textBuscador.setOnAction {
        // con cualquer letra al levantarse, ya ha cambiado el valor
        textBuscador.setOnKeyReleased { newValue ->
            newValue?.let { onKeyReleasedAction() }
        }
    }

    private fun onKeyReleasedAction() {
        logger.debug { "onKeyReleasedAction" }
        filterDataTable()
    }

    private fun filterDataTable() {
        logger.debug { "filterDataTable" }
        // filtramos por el tipo seleccionado en la tabla
        tableVehiculos.items = FXCollections.observableList(
            viewModel.VehiculosFilteredList(comboTipo.value, textBuscador.text.trim())
        )
    }

    private fun onTablaSelected(newValue: Vehiculo) {
        logger.debug { "onTablaSelected: $newValue" }
        viewModel.updateVehiculoSeleccionado(newValue)
    }

    private fun onComboSelected(newValue: String) {
        logger.debug { "onComboSelected: $newValue" }
        filterDataTable()
    }

    private fun onEliminarAction() {
        logger.debug { "onEliminarAction" }
        // Comprbar que se ha seleccionado antes!!
        if (tableVehiculos.selectionModel.selectedItem == null) {
            return
        }
        Alert(Alert.AlertType.CONFIRMATION).apply {
            title = "Eliminar Vehiculo"
            headerText = "¿Desea eliminar este alumno?"
            contentText = "Esta acción no se puede deshacer y se eliminarán todos los datos asociados."
        }.showAndWait().ifPresent { buttonType ->
            if (buttonType == ButtonType.OK) {
                viewModel.eliminarAlumno().onSuccess {
                    logger.debug { "eliminado correctamente" }
                }.onFailure {
                    logger.error { "Error al eliminar " }
                    showAlertOperacion(alerta = Alert.AlertType.ERROR, "Error al eliminar")
                }
            }
        }
    }

    private fun onEditarAction() {
        logger.debug { "onEditarAction" }
        if (tableCitas.selectionModel.selectedItem == null) {
            return
        }
        viewModel.setTipoOperacion(MainViewModel.TipoOperacion.EDITAR)
        RoutesManager.initDetalle()
    }

    private fun onNuevoAction() {
        logger.debug { "onNuevoAction" }
        // Poner el modo nuevo antes!!
        viewModel.setTipoOperacion(MainViewModel.TipoOperacion.NUEVO)
        RoutesManager.initDetalle()
    }

    private fun onAcercaDeAction() {
        logger.debug { "onAcercaDeAction" }
        RoutesManager.initAcercaDeStage()
    }
    private fun onVerAction() {
        logger.debug { "onAcercaDeAction" }
        RoutesManager.initDetalle()
    }
    private fun onInformeAction() {
        logger.debug { "onAcercaDeAction" }
        TODO()
    }

    private fun onExportarAction() {
        logger.debug { "onExportarAction" }
        FileChooser().run {
            title = "Exportar citas"
            extensionFilters.add(FileChooser.ExtensionFilter("JSON", "*.json"))
            showSaveDialog(RoutesManager.activeStage)
        }?.let {
            logger.debug { "onSaveAction: $it" }
            RoutesManager.activeStage.scene.cursor = Cursor.WAIT
            viewModel.saveCitasToJson(it)
                .onSuccess {
                    showAlertOperacion(
                        title = "Datos exportados",
                        header = "Datos exportados correctamente a fichero JSON",
                        mensaje = "Se ha exportado las citas desde el fichero de gestión.\nExportados: ${viewModel.state.value.citas.size}"
                    )
                }.onFailure { error ->
                    showAlertOperacion(alerta = Alert.AlertType.ERROR, title = "Error al exportar", mensaje = error.message)
                }
            RoutesManager.activeStage.scene.cursor = Cursor.DEFAULT
        }
    }

    private fun onImportarAction() {
        logger.debug { "onImportarAction" }
        FileChooser().run {
            title = "Importar citas"
            extensionFilters.add(FileChooser.ExtensionFilter("JSON", "*.json"))
            showOpenDialog(RoutesManager.activeStage)
        }?.let {
            logger.debug { "onAbrirAction: $it" }
            showAlertOperacion(
                Alert.AlertType.INFORMATION,
                title = "Importando datos",
                header = "Importando datos desde JSON",
                mensaje = "Importando datos Se sustituye la imagen por una imagen por defecto."
            )
            // Cambiar el cursor a espera
            RoutesManager.activeStage.scene.cursor = Cursor.WAIT
            viewModel.loadCitasFromJson(it)
                .onSuccess {
                    showAlertOperacion(
                        title = "Datos importados",
                        header = "Datos importados correctamente desde JSON",
                        mensaje = "Se ha importado tus Expedientes al sistema de gestión.\nImportados: ${viewModel.state.value.citas.size}"
                    )
                }.onFailure { error ->
                    showAlertOperacion(alerta = Alert.AlertType.ERROR, title = "Error al importar", mensaje = error.message)
                }
            RoutesManager.activeStage.scene.cursor = Cursor.DEFAULT
        }
    }

    // Método para salir de la aplicación
    fun onOnCloseAction() {
        logger.debug { "onOnCloseAction" }

        Alert(Alert.AlertType.CONFIRMATION).apply {
            title = "Salir"
            headerText = "Salir de Expedientes DAM"
            contentText = "¿Desea salir de Expedientes DAM?"
        }.showAndWait().ifPresent { buttonType ->
            if (buttonType == ButtonType.OK) {
                Platform.exit()
            }
        }
    }

    private fun showAlertOperacion(
        alerta: Alert.AlertType = Alert.AlertType.CONFIRMATION,
        title: String = "",
        header: String = "",
        mensaje: String = ""
    ) {
        Alert(alerta).apply {
            this.title = title
            this.headerText = header
            this.contentText = mensaje
        }.showAndWait()
    }


}