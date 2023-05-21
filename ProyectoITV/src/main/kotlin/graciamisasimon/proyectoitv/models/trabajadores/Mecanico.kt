package graciamisasimon.proyectoitv.models.trabajadores

import graciamisasimon.proyectoitv.models.enums.TipoTrabajador
import java.time.LocalDate

class Mecanico(
    override val estacionId: String,
    override val nombre: String,
    override val telefono: String,
    override val correo: String,
    override val usuario: String,
    override val tipo: TipoTrabajador,
    override val password: String,
    override val fechaContratacion: LocalDate,
    override val plusGerencia: Boolean
): ITrabajador {
    override fun salarioBase():Int{
        return 1600
    }
}