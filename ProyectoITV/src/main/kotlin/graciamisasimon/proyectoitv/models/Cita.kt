package graciamisasimon.proyectoitv.models


import graciamisasimon.proyectoitv.models.trabajadores.ITrabajador
import java.time.LocalDateTime

class Cita(val trabajador: ITrabajador, val vehiculo: Vehiculo, val fechaCita:LocalDateTime) {
    var valoresPruebas:ValoresPruebas = ValoresPruebas()
}