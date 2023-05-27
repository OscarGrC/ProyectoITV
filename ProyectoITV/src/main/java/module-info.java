module graciamisasimon.proyectoitv {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires open;

    // Logger
    requires io.github.microutils.kotlinlogging;
    requires org.slf4j;

    // Gson
    requires com.google.gson;

    // Result
    requires kotlin.result.jvm;

    // SqlDeLight
    requires runtime.jvm;

    // Como no pongas esto te vas a volver loco con los errores
    requires java.sql;

    //MariaDB
    requires org.mariadb.jdbc;

    // Koin
    requires koin.core.jvm;
    requires org.mybatis;

    // Abrimos y exponemos el paquete a JavaFX
    opens graciamisasimon.proyectoitv to javafx.fxml;
    exports graciamisasimon.proyectoitv;

    // Controladores
    opens graciamisasimon.proyectoitv.controllers to javafx.fxml;
    exports graciamisasimon.proyectoitv.controllers;

    // Rutas
    opens graciamisasimon.proyectoitv.routes to javafx.fxml;
    exports graciamisasimon.proyectoitv.routes;

    // dtos, abrimos a Gson
    opens graciamisasimon.proyectoitv.dto.json to com.google.gson;

    // Modelos a javafx para poder usarlos en las vistas
    opens graciamisasimon.proyectoitv.models to javafx.fxml;
    exports graciamisasimon.proyectoitv.models;


}