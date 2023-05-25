package graciamisasimon.proyectoitv.models


import java.time.LocalDate

class Cita(val trabajador: Trabajador, val vehiculo: Vehiculo, val fechaCita: LocalDate, val horaCita:String) {
    var valoresPruebas:ValoresPruebas = ValoresPruebas()
}