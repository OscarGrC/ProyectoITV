package graciamisasimon.proyectoitv.dto.json

data class VehiculoDto(val matricula:String, val marca:String, val modelo:String, val tipoVehiculo: String,
                        val tipoMotor: String, val fechaMatriculacion: String, val fechaUlimaRevision: String,
                       val nombreCliente:String, val apellidos:String, val telefonoCliente:String, val correoCliente:String,
                        val dni:String)
