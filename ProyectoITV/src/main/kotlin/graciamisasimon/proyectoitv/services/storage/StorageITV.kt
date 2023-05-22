package graciamisasimon.proyectoitv.services.storage

import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.models.Cita
import java.io.File

interface StorageITV {
    //una funcion para guardar citas
    fun storeDataJson(file: File, data: List<Cita>): Result<Long, AlumnoError>
    fun loadDataJson(file: File): Result<List<Alumno>, AlumnoError>
    fun saveImage(fileName: File): Result<File, AlumnoError>
    fun loadImage(fileName: String): Result<File, AlumnoError>
    fun deleteImage(fileName: File): Result<Unit, AlumnoError>
    fun deleteAllImages(): Result<Long, AlumnoError>
    fun updateImage(fileImage: File, newFileImage: File): Result<File, AlumnoError>
    fun exportToZip(fileToZip: File, data: List<Alumno>): Result<File, AlumnoError>
    fun loadFromZip(fileToUnzip: File): Result<List<Alumno>, AlumnoError>
}