package graciamisasimon.proyectoitv.mappers

import graciamisasimon.proyectoitv.dto.json.VehiculoDto
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.models.enums.TipoMotor
import graciamisasimon.proyectoitv.models.enums.TipoVehiculo
import java.time.LocalDate

fun Vehiculo.toDto():VehiculoDto{
    return VehiculoDto(
        matricula,marca,modelo,tipoVehiculo.name,tipoMotor.name,fechaMatriculacion.toString(),
        fechaUlimaRevision.toString(),propietario.nombre,propietario.apellidos,propietario.telefonoCliente,propietario.correoCliente,
        propietario.dni)
}

fun VehiculoDto.toVehiculo():Vehiculo{
    return Vehiculo(matricula,marca,modelo,TipoVehiculo.valueOf(tipoVehiculo),TipoMotor.valueOf(tipoMotor),
        LocalDate.parse(fechaMatriculacion),LocalDate.parse(fechaUlimaRevision),
        Cliente(nombreCliente, apellidos, telefonoCliente, correoCliente, dni))
}

fun List<Vehiculo>.toDto():List<VehiculoDto>{
    val salida = mutableListOf<VehiculoDto>()
        this.forEach { salida+=it.toDto() }
    return salida
}

fun List<VehiculoDto>.toVehiculo():List<Vehiculo>{
    val salida = mutableListOf<Vehiculo>()
    this.forEach { salida+=it.toVehiculo() }
    return salida
}