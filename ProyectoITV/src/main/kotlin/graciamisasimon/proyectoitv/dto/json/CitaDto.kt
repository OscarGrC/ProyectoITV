package graciamisasimon.proyectoitv.dto.json

class CitaDto(
    //primero el trabajador
    val estacionId:String, val nombre:String, val telefono:String, val correo:String, val usuario:String,
    val tipo: String,val password:String,val fechaContratacion: String,val plusGerencia:String,val sueldo:String,
    // ahora el vehiculo (vehiculoDto)
    val matricula:String, val marca:String, val modelo:String, val tipoVehiculo: String,
    val tipoMotor: String, val fechaMatriculacion: String, val fechaUlimaRevision: String, val imagen:String,
    val nombreCliente:String, val apellidos:String, val telefonoCliente:String, val correoCliente:String,val dni:String,
    // ahora la fecha de la cita y valores prueba
    val fechaCita: String,val horaCita:String,var frenado:String, var contaminacion:String,var interiores:String,
    var luces:String, var favorable:String
    ) {

}