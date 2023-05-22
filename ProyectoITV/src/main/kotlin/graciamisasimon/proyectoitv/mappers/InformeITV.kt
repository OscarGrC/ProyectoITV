package graciamisasimon.proyectoitv.mappers

import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.InformeITV

fun Cita.toInformeITV():InformeITV{
    return InformeITV(
        propietarioNombre = vehiculo.propietario.nombre, propietarioApellidos = vehiculo.propietario.apellidos,
        propietarioTelefono = vehiculo.propietario.telefonoCliente, propietarioCorreo = vehiculo.propietario.correoCliente,
        matricula=vehiculo.matricula,marca=vehiculo.marca,modelo=vehiculo.modelo,tipoVehiculo=vehiculo.tipoVehiculo.name
        ,tipoMotor =vehiculo.tipoMotor.name,fechaMatriculacion = vehiculo.fechaMatriculacion.toString(),
        fechaRevision =fechaCita.toString(), trabajadorNombre = trabajador.nombre, trabajadorUsuario=trabajador.usuario,
        estacionId = trabajador.estacionId, frenado = valoresPruebas.frenado.toString(),
        contaminacion = valoresPruebas.contaminacion.toString(), interiores = valoresPruebas.interiores.toString(),
        luces = valoresPruebas.luces.toString(), favorable = valoresPruebas.favorable.toString())
}

fun List<Cita>.toListInforme():List<InformeITV>{
    var salida = mutableListOf<InformeITV>()
    this.forEach { salida+= it.toInformeITV() }
    return  salida
}