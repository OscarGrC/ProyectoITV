package graciamisasimon.proyectoitv.services.storage

import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.errors.VehiculosError
import graciamisasimon.proyectoitv.models.Cita
import java.io.File

interface StorageITV {
    //una funcion para guardar citas
    fun storeDataJsonCita(file: File, data: List<Cita>): Result<Long, VehiculosError>
    fun loadDataJsonCita(file: File): Result<List<Cita>, VehiculosError>
    fun saveImage(fileName: File): Result<File, VehiculosError>
    fun loadImage(fileName: String): Result<File, VehiculosError>
    fun deleteImage(fileName: File): Result<Unit, VehiculosError>
    fun deleteAllImages(): Result<Long, VehiculosError>
    fun updateImage(fileImage: File, newFileImage: File): Result<File, VehiculosError>
    fun storeDataHTMLCita(fileToZip: File, data: List<Cita>): Result<File, VehiculosError>
    fun generarInforme(file: File, data:Cita): Result<Long, VehiculosError>
}