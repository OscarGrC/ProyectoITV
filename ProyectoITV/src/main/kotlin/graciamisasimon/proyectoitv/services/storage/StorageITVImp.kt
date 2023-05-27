package graciamisasimon.proyectoitv.services.storage

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import graciamisasimon.proyectoitv.config.AppConfig
import graciamisasimon.proyectoitv.dto.json.CitaDto
import graciamisasimon.proyectoitv.errors.VehiculosError
import graciamisasimon.proyectoitv.mappers.toCita
import graciamisasimon.proyectoitv.mappers.toDto
import graciamisasimon.proyectoitv.models.Cita
import mu.KotlinLogging
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.Instant


class StorageITVImp(private val appConfig: AppConfig) : StorageITV {
private val logger = KotlinLogging.logger {  }
        init {
            // Creamos el directorio de imagenes si no existe
            logger.debug { "Creando directorio de imagenes si no existe" }
            Files.createDirectories(Paths.get(appConfig.imagesDirectory))
        }

        override fun storeDataJsonCita(file: File, data: List<Cita>): Result<Long, VehiculosError> {
            logger.debug { "Guardando datos en fichero $file" }
            return try {
                val gson = GsonBuilder().setPrettyPrinting().create()
                val jsonString = gson.toJson(data.toDto())
                file.writeText(jsonString)
                Ok(data.size.toLong())
            } catch (e: Exception) {
                Err(VehiculosError.SaveJson("Error al escribir el JSON: ${e.message}"))
            }

        }

        override fun loadDataJsonCita(file: File): Result<List<Cita>, VehiculosError> {
            logger.debug { "Cargando datos en fichero $file" }
            val gson = GsonBuilder().setPrettyPrinting().create()
            // Debemos decirle el tipo de datos que queremos parsear
            val importType = object : TypeToken<List<CitaDto>>() {}.type
            return try {
                val jsonString = file.readText()
                val data = gson.fromJson<List<CitaDto>>(jsonString, importType)
                Ok(data.toCita())
            } catch (e: Exception) {
                Err(VehiculosError.LoadJson("Error al parsear el JSON: ${e.message}"))
            }

        }

        private fun getImagenName(newFileImage: File): String {
            val name = newFileImage.name
            val extension = name.substring(name.lastIndexOf(".") + 1)
            return "${Instant.now().toEpochMilli()}.$extension"
        }



    override fun saveImage(fileName: File): Result<File, VehiculosError> {
            logger.debug { "Guardando imagen $fileName" }
            return try {
                val newFileImage = File(appConfig.imagesDirectory + getImagenName(fileName))
                Files.copy(fileName.toPath(), newFileImage.toPath(), StandardCopyOption.REPLACE_EXISTING)
                Ok(newFileImage)
            } catch (e: Exception) {
                Err(VehiculosError.SaveImage("Error al guardar la imagen: ${e.message}"))
            }
        }

        override fun loadImage(fileName: String): Result<File, VehiculosError> {
            logger.debug { "Cargando imagen $fileName" }
            val file = File(appConfig.imagesDirectory + fileName)
            return if (file.exists()) {
                Ok(file)
            } else {
                Err(VehiculosError.LoadImage("La imagen no existe: ${file.name}"))
            }
        }

        override fun deleteImage(fileImage: File): Result<Unit, VehiculosError> {
            logger.debug { "Borrando imagen $fileImage" }
            Files.deleteIfExists(fileImage.toPath())
            return Ok(Unit)
        }

        override fun deleteAllImages(): Result<Long, VehiculosError> {
            logger.debug { "Borrando todas las imagenes" }
            return try {
                Ok(
                    Files.walk(Paths.get(appConfig.imagesDirectory))
                    .filter { Files.isRegularFile(it) }
                    .map { Files.deleteIfExists(it) }
                    .count())
            } catch (e: Exception) {
                Err(VehiculosError.DeleteImage("Error al borrar todas las imagenes: ${e.message}"))
            }
        }

        override fun updateImage(fileImage: File, newFileImage: File): Result<File, VehiculosError> {
            logger.debug { "Actualizando imagen ${fileImage.name}" }
            return try {
                val newUpdateImage = File(appConfig.imagesDirectory + fileImage.name)
                Files.copy(newFileImage.toPath(), newUpdateImage.toPath(), StandardCopyOption.REPLACE_EXISTING)
                Ok(newUpdateImage)
            } catch (e: Exception) {
                Err(VehiculosError.SaveImage("Error al guardar la imagen: ${e.message}"))
            }
        }

    override fun storeDataHTMLCita(fileToZip: File, data: List<Cita>): Result<File, VehiculosError> {
        TODO("Not yet implemented")
    }

    override fun generarInforme(file: File, data: Cita): Result<Long, VehiculosError> {
        TODO("Not yet implemented")
    }


}