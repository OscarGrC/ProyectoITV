package graciamisasimon.proyectoitv.repositories

import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.services.database.DataBaseManager
import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
// tenemos que crear la bbdd y almacenamiento como va por inyeccion solo cambiar la inyeccion
class ITVRepositotyImp(private val dataBaseClient:DataBaseManager ):ITVRepository {

    val database = dataBaseClient
    private fun createCliente(cliente: Cliente): Cliente {
        logger.debug { "createCliente: $cliente" }
        // Insertamos, transacción por funcion de sqlite (mira el .sq)
        database.transaction {
            database.insertCliente(cliente)
        }
        return cliente
    }
    private fun createVehiculo(vehiculo: Vehiculo): Vehiculo {
        logger.debug { "createVehiculo: $vehiculo" }
        // Insertamos, transacción por funcion de sqlite (mira el .sq)
        //añadimos primero cliente
        createCliente(vehiculo.propietario)
        database.transaction {
            database.insertVehiculos(vehiculo)
        }
        return vehiculo
    }

    private fun updateCliente(cliente: Cliente): Cliente {
        logger.debug { "updateCliente: $cliente" }
        database.upadateCliente(cliente)
        return cliente
    }
    private fun updateVehiculo(vehiculo: Vehiculo): Vehiculo {
        logger.debug { "updateVehiculo: $vehiculo" }
        //modifico aqui salvamos propietario vehiculo
        database.updateVehiculo(vehiculo)
        return vehiculo
    }

    override fun findAllVehiculos(): List<Vehiculo> {
        logger.debug { "findAllVehiculos" }
        return database.selectAllVehiculos()
    }


    override fun findAllClientes(): List<Cliente> {
        logger.debug { "findAllClientes" }
        return database.selectAllClientes()
    }

    override fun findClientesByDNI(dni: String): Cliente? {
        logger.debug { "findClientesByDNI: $dni" }

        return database.selectClientesByDNI(dni).executeAsOneOrNull()?.toModel()
    }

    override fun findVehiculoByMatricula(matricula: String): Vehiculo? {
        logger.debug { "findVehiculoByMatricula: $matricula" }
        return database.selectVehiculosByMatricula(matricula).executeAsOneOrNull()?.toModel()
    }

    override fun findVehiculoByPropietario(dni: String): List<Vehiculo> {
        logger.debug { "findVehiculoByPropietario $dni" }
        return database.selectVehiculosByPropietario(dni)
    }

    override fun saveCliente(cliente: Cliente): Cliente {
        logger.debug { "saveCliente: $cliente" }

        return if (findClientesByDNI(cliente.dni)==null) {
            createCliente(cliente)
        } else {
            updateCliente(cliente)
        }
    }

    override fun saveVehiculo(vehiculo: Vehiculo): Vehiculo {
        logger.debug { "saveVehiculo: $vehiculo" }
        return if (findVehiculoByMatricula(vehiculo.matricula)== null) {
            createVehiculo(vehiculo)
        } else {
            updateVehiculo(vehiculo)
        }
    }

    override fun deleteClienteByDNI(dni: String) {
        logger.debug { "deleteClienteByDNI: $dni" }
        return database.deleteClientes(dni)
    }

    override fun deleteVehiculoByMatricula(matricula: String) {
        logger.debug { "deleteVehiculoByMatricula: $matricula" }
        return database.deleteVehiculo(matricula)
    }

    override fun deleteAllVehiculos() {
        logger.debug { "deleteAllVehiculos" }
        return database.deleteAllVehiculos()
    }

    override fun deleteAllClientes() {
        logger.debug { "deleteAllClientes" }
        return database.deleteAllClientes()
    }

    override fun saveAllClientes(clientes: List<Cliente>): List<Cliente> {
        logger.debug { "saveAllClientes: $clientes" }
        return clientes.map { saveCliente(it) }
    }

    override fun saveAllVehiculos(vehiculos: List<Vehiculo>): List<Vehiculo> {
        logger.debug { "saveAllVehiculos: $vehiculos" }
        return vehiculos.map { saveVehiculo(it) }
    }
    override fun createCita(cita: Cita): Cita {
        TODO("Not yet implemented")
    }

    override fun deleteCita(cita: Cita): Cita {
        TODO("Not yet implemented")
    }

    override fun upDateCita(cita: Cita): Cita {
        TODO("Not yet implemented")
    }

    override fun deleteAllCita() {
        TODO("Not yet implemented")
    }

    override fun findAllCita(): List<Cita> {
        TODO("Not yet implemented")
    }

    override fun createInformeCita(cita: Cita): InformeITV {
        TODO("Not yet implemented")
    }

    override fun deleteInformeCita(cita: Cita): InformeITV {
        TODO("Not yet implemented")
    }
}