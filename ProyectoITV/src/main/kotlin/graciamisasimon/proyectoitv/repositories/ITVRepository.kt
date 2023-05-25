package graciamisasimon.proyectoitv.repositories

import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.Vehiculo

interface ITVRepository {
        fun findAllVehiculos(): List<Vehiculo>
        fun findAllClientes(): List<Cliente>
        fun findClientesByDNI(dni: String): Cliente?
        fun findVehiculoByMatricula(matricula: String): Vehiculo?
        fun findVehiculoByPropietario(dni: String): List<Vehiculo>
        fun saveCliente(cliente: Cliente): Cliente
        fun saveVehiculo(vehiculo: Vehiculo): Vehiculo
        fun deleteClienteByDNI(dni: String)
        fun deleteVehiculoByMatricula(matricula: String)
        fun deleteAllVehiculos()
        fun deleteAllClientes()
        fun saveAllClientes(clientes: List<Cliente>): List<Cliente>
        fun saveAllVehiculos(vehiculos: List<Vehiculo>): List<Vehiculo>
        fun createCita(cita:Cita):Cita
        fun deleteCita(cita: Cita):Cita
        fun upDateCita(cita: Cita):Cita
        fun deleteAllCita()
        fun findAllCita():List<Cita>
        fun createInformeCita(cita: Cita):InformeITV
        fun deleteInformeCita(cita: Cita):InformeITV

}