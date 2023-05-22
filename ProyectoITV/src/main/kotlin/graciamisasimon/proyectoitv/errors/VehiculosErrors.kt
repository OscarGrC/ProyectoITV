package graciamisasimon.proyectoitv.errors

sealed class VehiculosError(val message: String) {
    class LoadJson(message: String) : VehiculosError(message)
    class SaveJson(message: String) : VehiculosError(message)
    class LoadImage(message: String) : VehiculosError(message)
    class SaveImage(message: String) : VehiculosError(message)
    class DeleteImage(message: String) : VehiculosError(message)
    class ValidationProblem(message: String) : VehiculosError(message)
    class NotFound(message: String) : VehiculosError(message)
    class ExportZip(message: String) : VehiculosError(message)
    class ImportZip(message: String) : VehiculosError(message)
}