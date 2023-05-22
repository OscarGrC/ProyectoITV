package graciamisasimon.proyectoitv.mappers

import graciamisasimon.proyectoitv.dto.json.CitaDto
import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.models.enums.TipoMotor
import graciamisasimon.proyectoitv.models.enums.TipoVehiculo
import java.time.LocalDate

fun Cita.toCitaDto():CitaDto{
    return CitaDto( estacionId = trabajador.estacionId,nombre= trabajador.nombre,telefono= trabajador.telefono,
        correo= trabajador.correo,usuario=trabajador.usuario,tipo=trabajador.tipo.name,password = trabajador.password,
        fechaContratacion=trabajador.fechaContratacion.toString(),plusGerencia=trabajador.plusGerencia.toString()
        ,sueldo=trabajador.sueldo.toString(),
    // ahora el vehiculo (vehiculoDto)
    matricula=vehiculo.matricula,marca=vehiculo.marca,modelo=vehiculo.modelo,tipoVehiculo=vehiculo.tipoVehiculo.name,
    tipoMotor=vehiculo.tipoMotor.name,fechaMatriculacion=vehiculo.fechaMatriculacion.toString(),
        fechaUlimaRevision=vehiculo.fechaUlimaRevision.toString(),nombreCliente=vehiculo.propietario.nombre,
        apellidos = vehiculo.propietario.apellidos,telefonoCliente=vehiculo.propietario.telefonoCliente,
        correoCliente=vehiculo.propietario.correoCliente,dni=vehiculo.propietario.dni, imagen = vehiculo.imagen,
    // ahora la fecha de la cita y valores prueba
    fechaCita=fechaCita.toString(),frenado= valoresPruebas.frenado.toString(),
        contaminacion=valoresPruebas.contaminacion.toString(),interiores=valoresPruebas.interiores.toString(),
    luces=valoresPruebas.luces.toString(),favorable=valoresPruebas.favorable.toString())
}

fun CitaDto.toCita():Cita{
    val localTrabajador = claseDeTrabajador(this.tipo)
    val localCliente = Cliente(nombre, apellidos, telefonoCliente, correoCliente, dni)
    val localVehiculo = Vehiculo(matricula,marca,modelo, TipoVehiculo.valueOf(tipoVehiculo),
        TipoMotor.valueOf(tipoMotor),LocalDate.parse(fechaMatriculacion),LocalDate.parse(fechaUlimaRevision),
        propietario = localCliente, imagen)

}
   private  fun claseDeTrabajador(tipo:String){
        when(tipo){

        }
    }
