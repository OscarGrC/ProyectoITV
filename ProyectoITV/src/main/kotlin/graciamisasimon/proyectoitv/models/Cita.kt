package graciamisasimon.proyectoitv.models


import java.time.LocalDateTime

class Cita(val trabajador: Trabajador, val vehiculo: Vehiculo, val fechaCita:LocalDateTime) {
    var valoresPruebas:ValoresPruebas = ValoresPruebas()
}