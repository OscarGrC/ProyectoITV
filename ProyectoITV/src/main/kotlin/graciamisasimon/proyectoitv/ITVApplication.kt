package graciamisasimon.proyectoitv

import graciamisasimon.proyectoitv.di.AppDIModulo
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class ITVApplication : Application(), KoinComponent {
    init {
        // creamos Koin
        startKoin {
            modules(AppDIModulo) // Módulos de Koin
        }
    }
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