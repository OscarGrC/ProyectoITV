package graciamisasimon.proyectoitv.di


import graciamisasimon.proyectoitv.repositories.ITVRepository
import graciamisasimon.proyectoitv.repositories.ITVRepositotyImp
import graciamisasimon.proyectoitv.services.storage.StorageITV
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val AppDIModulo = module {
        singleOf(::AppConfig)
        singleOf(::DataBaseManager)
        singleOf(::ITVRepositoryImp) {
            bind<ITVRepository>()
        }
        singleOf(::StorageITVImp) {
            bind<StorageITV>()
        }
        singleOf(::ExpedientesViewModel)
    }
