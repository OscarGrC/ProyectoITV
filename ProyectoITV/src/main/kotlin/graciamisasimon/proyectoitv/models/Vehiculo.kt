package graciamisasimon.proyectoitv.models

import graciamisasimon.proyectoitv.models.enums.TipoMotor
import graciamisasimon.proyectoitv.models.enums.TipoVehiculo
import java.time.LocalDate

data class Vehiculo(
    val matricula:String,
    val marca:String, val modelo:String,
    val tipoVehiculo: TipoVehiculo,
    val tipoMotor: TipoMotor,
    val fechaMatriculacion:LocalDate,
    val fechaUlimaRevision:LocalDate?,
    val propietario: Cliente,
    var imagen: String ="images/notFound.png"){

}