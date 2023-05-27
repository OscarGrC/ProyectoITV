package graciamisasimon.proyectoitv.models

data class Cliente(
    val dni: String,
    val nombre: String,
    val apellidos: String,
    val telefonoCliente: Int,
    val correoCliente: String
)
