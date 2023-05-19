package graciamisasimon.proyectoitv.repositories

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

}