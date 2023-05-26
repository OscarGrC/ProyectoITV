package graciamisasimon.proyectoitv

import graciamisasimon.proyectoitv.di.AppDIModule
import graciamisasimon.proyectoitv.routes.RoutesManager
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.koin.core.context.startKoin

class ITVApplication : Application() {
    override fun start(stage: Stage) {
        startKoin {
            printLogger()
            modules(AppDIModule)

        }
        RoutesManager.apply {
            app = this@ITVApplication
        }
        RoutesManager.initMainStage(stage)

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