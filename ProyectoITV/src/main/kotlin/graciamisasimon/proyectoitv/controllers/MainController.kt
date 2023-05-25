package graciamisasimon.proyectoitv.controllers

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
    private val logger = KotlinLogging.logger {  }
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
            updatesFormulario(oldState, newState)
            updatesTabla(newState, oldState)
        }
    }



}