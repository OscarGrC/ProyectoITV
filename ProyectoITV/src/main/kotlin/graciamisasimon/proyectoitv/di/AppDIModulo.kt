package graciamisasimon.proyectoitv.di

import graciamisasimon.proyectoitv.config.AppConfig
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf


val AppDIModulo = module {
        singleOf(::AppConfig)
    }
