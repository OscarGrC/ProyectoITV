module graciamisasimon.proyectoitv {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlin.result.jvm;
    requires io.github.microutils.kotlinlogging;


    opens graciamisasimon.proyectoitv to javafx.fxml;
    exports graciamisasimon.proyectoitv;
}