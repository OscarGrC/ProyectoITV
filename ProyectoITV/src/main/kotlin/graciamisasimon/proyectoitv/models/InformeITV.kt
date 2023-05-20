package graciamisasimon.proyectoitv.models

data class InformeITV(
//Esta es la clase que almacenaremos en Json llamada Informe con todos los valores de la cita empezasmos con Cliente
    val propietarioNombre:String, val propietarioApellidos:String, val propietarioTelefono:String, val propietarioCorreo:String,
// Datos del Vehiculo
    val matricula:String, val marca:String, val modelo:String, val tipoVehiculo: String,
    val tipoMotor: String, val fechaMatriculacion: String,
// Datos cita y Trabajador
    val fechaRevision:String, val trabajadorNombre:String, val trabajadorUsuario:String, val estacionId:String,
// los valores de la prueba
    var frenado:String, val contaminacion:String, val interiores:String, val luces:String, val favorable:String
) {
    fun Informe():String{
        return "El dia $fechaRevision,en la ITV $estacionId. El tecnico:$trabajadorUsuario. Procede a revisar \n" +
               "El vehiculo con matricula: $matricula, Marca:$marca, Modelo:$modelo,matricula en $fechaMatriculacion \n" +
               "El cual esta en la categoria $tipoVehiculo, con un motor de tipo $tipoMotor. \n" +
                "Con los siguientes resultados \n" +
                "----------------------------- \n" +
                // en el mundo real la eficacia de frenado tiene que ser superiror al 50% de sin desequilibrios
                "Fuerza de frenada $frenado% de eficacia  \n" +
                "Emisiones de Gases $contaminacion P.P.M \n" +
                "Estado de luces $luces, Estado de interiores $interiores \n" +
                "Resultado del informe:$favorable \n" +
                "------------------------------ \n" +
                "Se informa al Cliente $propietarioNombre $propietarioApellidos, con telefono $propietarioTelefono \n" +
                "tambien se le mandara copia del mismo a su correo electronico $propietarioCorreo"
    }
}
