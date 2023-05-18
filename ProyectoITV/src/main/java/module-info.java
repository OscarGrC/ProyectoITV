module graciamisasimon.proyectoitv {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens graciamisasimon.proyectoitv to javafx.fxml;
    exports graciamisasimon.proyectoitv;
}