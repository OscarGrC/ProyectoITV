package graciamisasimon.proyectoitv.services.storage

import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.errors.VehiculosError
import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Vehiculo
import java.io.File

interface StorageITV {
    //una funcion para guardar citas
    fun storeDataJson(file: File, data: List<Cita>): Result<Long, VehiculosError>
    fun loadDataJson(file: File): Result<List<Vehiculo>, VehiculosError>
    fun saveImage(fileName: File): Result<File, VehiculosError>
    fun loadImage(fileName: String): Result<File, VehiculosError>
    fun deleteImage(fileName: File): Result<Unit, VehiculosError>
    fun deleteAllImages(): Result<Long, VehiculosError>
    fun updateImage(fileImage: File, newFileImage: File): Result<File, VehiculosError>
    fun exportToZip(fileToZip: File, data: List<Vehiculo>): Result<File, VehiculosError>
    fun loadFromZip(fileToUnzip: File): Result<List<Vehiculo>, VehiculosError>
}