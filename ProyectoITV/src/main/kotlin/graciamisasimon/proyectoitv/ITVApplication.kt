package graciamisasimon.proyectoitv

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class ITVApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(ITVApplication::class.java.getResource("views/main-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 1050.0, 740.0)
        stage.title = "ITV en ETV!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(ITVApplication::class.java)
}