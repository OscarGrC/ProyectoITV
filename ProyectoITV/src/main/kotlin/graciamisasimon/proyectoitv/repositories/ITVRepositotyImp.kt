package graciamisasimon.proyectoitv.repositories

import graciamisasimon.proyectoitv.models.Cita
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.InformeITV
import graciamisasimon.proyectoitv.models.Vehiculo
import mu.KotlinLogging

private val logger = KotlinLogging.logger {  }
// tenemos que crear la bbdd y almacenamiento como va por inyeccion solo cambiar la inyeccion
class ITVRepositotyImp(private val dataBaseClient ):ITVRepository {

    val database = dataBaseClient.database
    private fun createCliente(cliente: Cliente): Cliente {
        logger.debug { "createCliente: $cliente" }
        // Insertamos, transacción por funcion de sqlite (mira el .sq)
        database.transaction {
            database.insertClientes(
                dni = cliente.dni,
                nombre = cliente.nombre,
                apellidos = cliente.apellidos,
                correo = cliente.correo,
                telefono = cliente.telefono
            )
        }
        return cliente
    }
    private fun createVehiculo(vehiculo: Vehiculo): Vehiculo {
        logger.debug { "createVehiculo: $vehiculo" }
        // Insertamos, transacción por funcion de sqlite (mira el .sq)
        //añadimos primero cliente
        createCliente(vehiculo.propietario)
        database.transaction {
            database.insertVehiculos(
                matricula = vehiculo.matricula,
                marca = vehiculo.marca,
                modelo = vehiculo.modelo,
                tipoVehiculo = vehiculo.tipoVehiculo.name,
                tipoMotor = vehiculo.tipoMotor.name,
                fechaUltimaRevision = vehiculo.fechaUlimaRevision.toString(),
                fechaMatriculacion = vehiculo.fechaMatriculacion.toString(),
                propietario = vehiculo.propietario.dni,
                imagen = vehiculo.imagen
            )
        }
        return vehiculo
    }

    private fun updateCliente(cliente: Cliente): Cliente {
        logger.debug { "updateCliente: $cliente" }
        database.updateClientes(
            dni = cliente.dni,
            nombre = cliente.nombre,
            apellidos = cliente.apellidos,
            email = cliente.correo,
            telefono = cliente.telefono
        )
        return cliente
    }
    private fun updateVehiculo(vehiculo: Vehiculo): Vehiculo {
        logger.debug { "updateVehiculo: $vehiculo" }
        //modifico aqui salvamos propietario vehiculo
        updateCliente(vehiculo.propietario)
        database.update(
            matricula = vehiculo.matricula,
            marca = vehiculo.marca,
            modelo = vehiculo.modelo,
            tipoVehiculo = vehiculo.tipoVehiculo.name,
            tipoMotor = vehiculo.tipoMotor.name,
            fechaUltimaRevision = vehiculo.fechaUlimaRevision.toString(),
            fechaMatriculacion = vehiculo.fechaMatriculacion.toString(),
            propietario = vehiculo.propietario.dni,
            imagen = vehiculo.imagen
        )
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

    override fun createInformeCita(cita: Cita): InformeITV {
        TODO("Not yet implemented")
    }

    override fun deleteInformeCita(cita: Cita): InformeITV {
        TODO("Not yet implemented")
    }
}