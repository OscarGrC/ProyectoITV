package graciamisasimon.proyectoitv.services.database

import graciamisasimon.proyectoitv.config.AppConfig
import graciamisasimon.proyectoitv.models.Cliente
import graciamisasimon.proyectoitv.models.Vehiculo
import graciamisasimon.proyectoitv.models.enums.TipoMotor
import graciamisasimon.proyectoitv.models.enums.TipoVehiculo
import mu.KotlinLogging
import org.apache.ibatis.jdbc.ScriptRunner
import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.sql.*
import java.util.*


private val logger = KotlinLogging.logger {}


class DataBaseManager(
    private val appConfig: AppConfig
) : Closeable {
    // Parámetros de conexión
    private lateinit var serverUrl: String
    private lateinit var serverPort: String
    private lateinit var dataBaseName: String
    private lateinit var user: String
    private lateinit var password: String
    private lateinit var initScript: String
    private lateinit var jdbcDriver: String
    private lateinit var connectionUrl: String


    private var connection: Connection? = null
    private var preparedStatement: PreparedStatement? = null

    val db
        get() = DriverManager.getConnection(appConfig.databaseUrl)

    init {
        logger.debug { "Inicializando el gestor de Bases de Datos" }
        initConfig()
    }

    /**
     * Carga la configuración de acceso al servidor de Base de Datos
     * Puede ser directa "hardcodeada" o asignada dinámicamente a traves de ficheros .env o properties
     */
    private fun initConfig() {
        // Leemos el fichero de configuración
        val propsFile = ClassLoader.getSystemResource("config.properties").file
        propsFile?.let {
            logger.debug { "Cargando fichero de configuración de la Base de Datos: $propsFile" }
            val props = Properties()
            props.load(FileInputStream(propsFile))

            // Comentar o ajustar segun el tipo de base de datos y propiedades que se quieran usar
            serverUrl = props.getProperty("database.url", "localhost")
            serverPort = props.getProperty("database.port", "3307")
            dataBaseName = props.getProperty("database.name", "itvdatabase")
            jdbcDriver = props.getProperty("database.driver", "com.mysql.cj.jdbc.Driver")
            user = props.getProperty("database.user", "root")
            password = props.getProperty("database.password", "1234")
            connectionUrl =
                props.getProperty("database.connectionUrl", "jdbc:Mariadb:mem:${this.dataBaseName};DB_CLOSE_DELAY=-1")
            // initScript = props.getProperty("database.initScript", ClassLoader.getSystemResource("init.sql").file)
        }
        logger.debug { "Configuración de acceso a la Base de Datos cargada" }
    }

    /**
     * Establece la conexión con la Base de Datos
     * @return true si la conexión se ha establecido correctamente, false en caso contrario
     */
    @Throws(SQLException::class)
    fun open() {
        // Obtenemos la conexión
        if (connection != null && !connection!!.isClosed) {
            logger.debug { "Conexión a la Base de Datos ya establecida" }
            return
        }
        connection = DriverManager.getConnection(connectionUrl, user, password)
        logger.debug { "Conexión a la Base de Datos establecida: $connectionUrl" }
    }

    /**
     * Cierra la conexión con el servidor de base de datos
     *
     * @throws SQLException Servidor no responde o no puede realizar la operación de cierre
     */
    @Throws(SQLException::class)
    override fun close() {
        preparedStatement?.close()
        connection?.close()
        logger.debug { "Conexión a la Base de Datos cerrada" }
    }

    /**
     * Realiza una consulta a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    @Throws(SQLException::class)
    private fun executeQuery(querySQL: String, vararg params: Any?): ResultSet? {
        this.open()

        preparedStatement = connection?.prepareStatement(querySQL)
        // Si hay parámetros, los asignamos
        return preparedStatement?.let {
            for (i in params.indices) {
                it.setObject(i + 1, params[i])
            }
            logger.debug { "Ejecutando consulta: $querySQL con parámetros: ${params.contentToString()}" }
            it.executeQuery()
        }
    }

    /**
     * Realiza una consulta select a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    @Throws(SQLException::class)
    fun select(querySQL: String, vararg params: Any?): ResultSet? {
        return executeQuery(querySQL, *params)
    }

    /**
     * Realiza una consulta select a la base de datos de manera "preparada" obteniendo los parametros opcionales si son necesarios
     *
     * @param querySQL consulta SQL de tipo select
     * @param limit    número de registros de la página
     * @param offset   desplazamiento de registros o número de registros ignorados para comenzar la devolución
     * @param params   parámetros de la consulta parametrizada
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe o el desplazamiento es mayor que el número de registros
     */
    @Throws(SQLException::class)
    fun select(querySQL: String, limit: Int, offset: Int, vararg params: Any?): ResultSet? {
        val query = "$querySQL LIMIT $limit OFFSET $offset"
        return executeQuery(query, *params)
    }

    /**
     * Realiza una consulta de tipo insert de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param insertSQL consulta SQL de tipo insert
     * @param params    parámetros de la consulta parametrizada
     * @return Clave del registro insertado si es autonumerico
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    @Throws(SQLException::class)
    fun insertAndGetKey(insertSQL: String, vararg params: Any?): ResultSet? {
        this.open()
        // Con return generated keys obtenemos las claves generadas las claves es autonumerica por ejemplo,
        // el id de la tabla si es autonumérico. Si no quitar.
        preparedStatement = connection?.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)
        // Si hay parámetros, los asignamos
        return preparedStatement?.let {
            for (i in params.indices) {
                it.setObject(i + 1, params[i])
            }
            logger.debug { "Ejecutando consulta: $insertSQL con parámetros: ${params.contentToString()}" }
            it.executeUpdate()
            it.generatedKeys
        }
    }

    // USO esta función porque los UUID los genero desde la propia aplicación
    @Throws(SQLException::class)
    fun insert(insertSQL: String, vararg params: Any?): Int {
        return updateQuery(insertSQL, *params)
    }

    /**
     * Realiza una consulta de tipo update de manera "preparada" con los parametros opcionales si son necesarios
     *
     * @param updateSQL consulta SQL de tipo update
     * @param params    parámetros de la consulta parametrizada
     * @return número de registros actualizados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    @Throws(SQLException::class)
    fun update(updateSQL: String, vararg params: Any?): Int {
        return updateQuery(updateSQL, *params)
    }

    /**
     * Realiza una consulta de tipo delete de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param deleteSQL consulta SQL de tipo delete
     * @param params    parámetros de la consulta parametrizada
     * @return número de registros eliminados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    @Throws(SQLException::class)
    fun delete(deleteSQL: String, vararg params: Any?): Int {
        return updateQuery(deleteSQL, *params)
    }

    /**
     * Realiza una consulta de tipo update, es decir que modifca los datos, de manera "preparada" con los parametros opcionales si son encesarios
     *
     * @param genericSQL consulta SQL de tipo update, delete, creted, etc.. que modifica los datos
     * @param params     parámetros de la consulta parametrizada
     * @return número de registros eliminados
     * @throws SQLException tabla no existe o no se ha podido realizar la operación
     */
    @Throws(SQLException::class)
    private fun updateQuery(genericSQL: String, vararg params: Any?): Int {
        this.open()

        // Con return generated keys obtenemos las claves generadas
        preparedStatement = connection?.prepareStatement(genericSQL)
        // Si hay parámetros, los asignamos
        return preparedStatement?.let {
            for (i in params.indices) {
                preparedStatement!!.setObject(i + 1, params[i])
            }
            logger.debug { "Ejecutando consulta: $genericSQL con parámetros: ${params.contentToString()}" }
            it.executeUpdate()
        } ?: 0

    }

    fun createTables(genericSQL: String): Int {
        logger.debug { "Creando Tablas..." }
        return updateQuery(genericSQL)
    }

    // Por si es necesario en algunos casos
    /**
     * Inicia una transacción
     *
     * @throws SQLException
     */
    @Throws(SQLException::class)
    private fun beginTransaction() {
        connection?.autoCommit = false
    }

    /**
     * Confirma una transacción
     *
     * @throws SQLException
     */
    @Throws(SQLException::class)
    private fun commit() {
        connection?.commit()
        connection?.autoCommit = true
    }

    /**
     * Cancela una transacción
     *
     * @throws SQLException
     */
    @Throws(SQLException::class)
    private fun rollback() {
        connection?.rollback()
        connection?.autoCommit = true
    }

    /**
     * Realiza unas operaciones en una transacción
     * @param operations operaciones a realizar
     * @throws SQLException si no se ha podido realizar la transacción
     */
    fun transaction(operations: () -> Unit) {
        open()
        try {
            logger.debug { "Transaction iniciada" }
            beginTransaction()
            // Aquí las operaciones
            operations()
            commit()
            logger.debug { "Transaction finalizada" }
        } catch (e: SQLException) {
            rollback()
            logger.error { "Error en la transacción: ${e.message}" }
            throw SQLException(e)
        }
    }

    /**
     * Ejecuta un script que se pasa como
     *
     * @param sqlFile
     * @throws FileNotFoundException
     */
    @Throws(FileNotFoundException::class)
    fun initData(sqlFile: String = this.initScript, logWriter: Boolean = false) {
        logger.debug { "Iniciando datos del fichero: $sqlFile y logWriter: $logWriter" }
        this.open()
        check(Files.exists(Paths.get(sqlFile))) { "El fichero $sqlFile no existe" }
        val sr = ScriptRunner(connection)
        val reader: Reader = BufferedReader(FileReader(sqlFile))
        sr.setLogWriter(if (logWriter) PrintWriter(System.out) else null)
        sr.runScript(reader)
    }


    /**
     * Realiza una consulta INSERT a la base de datos insertando los clientes
     *
     * @param insertCliente consulta SQL de tipo insert
     * @param params cliente a insertar
     * @return ResultSet de la consulta
     * @throws SQLException No se ha podido realizar la consulta o la tabla no existe
     */
    fun insertCliente(cliente : Cliente) {
        logger.debug { "Guardando un cliente en la base de datos" }

        val sql = """
            INSERT INTO cliente VALUES (?,?,?,?,?)
        """.trimIndent()

        db.use {
            it.prepareStatement(sql).use { stm ->
                stm.setCharacterStream(1, cliente.dni.reader())
                stm.setCharacterStream(2, cliente.nombre.reader())
                stm.setCharacterStream(3, cliente.apellidos.reader())
                stm.setInt(4, cliente.telefonoCliente)
                stm.setCharacterStream(5, cliente.correoCliente.reader())

                stm.executeUpdate()
            }
        }
    }


    fun upadateCliente(cliente : Cliente) {
        logger.debug { "Actualizando un cliente en la base de datos" }

        val sql = """
            UPDATE cliente VALUES SET cliente_nombre =?, cliente_apellido =?, cliente_telefono =?,cliente_correo =? WHERE cliente_dni =?
        """.trimIndent()

        db.use {
            it.prepareStatement(sql).use { stm ->
                stm.setCharacterStream(1, cliente.nombre.reader())
                stm.setCharacterStream(2, cliente.apellidos.reader())
                stm.setInt(3, cliente.telefonoCliente)
                stm.setCharacterStream(4, cliente.correoCliente.reader())
                stm.setCharacterStream(5, cliente.dni.reader())
                stm.executeUpdate()
            }
        }
    }

    fun insertVehiculos(vehiculo: Vehiculo) {
        logger.debug { "Guardando un vehículo en la base de datos" }

        val sql = """
            INSERT INTO vehiculo VALUES (?,?,?,?,?,?,?,?,?)
        """.trimIndent()

        db.use {
            it.prepareStatement(sql).use { stm ->
                stm.setCharacterStream(1, vehiculo.matricula.reader())
                stm.setCharacterStream(2, vehiculo.propietario.dni.reader())
                stm.setCharacterStream(3, vehiculo.marca.reader())
                stm.setCharacterStream(4, vehiculo.modelo.reader())
                stm.setCharacterStream(5, vehiculo.tipoVehiculo.name.reader())
                stm.setCharacterStream(6, vehiculo.tipoMotor.name.reader())
                stm.setDate(7, java.sql.Date.valueOf(vehiculo.fechaMatriculacion))
                stm.setDate(8, java.sql.Date.valueOf(vehiculo.fechaUlimaRevision))

                stm.executeUpdate()
            }
        }
    }

    fun updateVehiculo(vehiculo: Vehiculo) {
        logger.debug { "Actualizando un vehículo en la base de datos" }

        val sql = """
            UPDATE vehiculo VALUES SET cliente_dni =?, vehiculo_marca =?, vehiculo_modelo =?, vehiculo_tipo =?, vehiculo_tipo_motor =?, vehiculo_fecha_matriculacion =?, vehiculo_fecha_ult_version =? WHERE matricula =?
        """.trimIndent()

        db.use {
            it.prepareStatement(sql).use { stm ->
                stm.setCharacterStream(1, vehiculo.propietario.dni.reader())
                stm.setCharacterStream(2, vehiculo.marca.reader())
                stm.setCharacterStream(3, vehiculo.modelo.reader())
                stm.setCharacterStream(4, vehiculo.tipoVehiculo.name.reader())
                stm.setCharacterStream(5, vehiculo.tipoMotor.name.reader())
                stm.setDate(6, java.sql.Date.valueOf(vehiculo.fechaMatriculacion))
                stm.setDate(7, java.sql.Date.valueOf(vehiculo.fechaUlimaRevision))
                stm.setCharacterStream(8, vehiculo.matricula.reader())

                stm.executeUpdate()
            }
        }
    }

    fun selectAllVehiculos() {
        val sql = "SELECT * FROM vehiculo"

        val vehiculos = mutableListOf<Vehiculo>()

        db.use {
            it.prepareStatement(sql).use { stm ->
                val rs = stm.executeQuery()
                while (rs.next()) {
                    vehiculos.add(
                        Vehiculo(
                            matricula = rs.getCharacterStream("matricula").toString(),
                            marca = rs.getCharacterStream("vehiculo_marca").toString(),
                            modelo = rs.getCharacterStream("vehiculo_modelo").toString(),
                            tipoVehiculo = TipoVehiculo.valueOf(rs.getCharacterStream("vehiculo_tipo").toString()),
                            tipoMotor = TipoMotor.valueOf(rs.getCharacterStream("vehiculo_tipo_motor").toString()),
                            fechaMatriculacion = rs.getDate("vehiculo_fecha_matriculacion").toLocalDate(),
                            fechaUlimaRevision = rs.getDate("vehiculo_fecha_ult_version").toLocalDate(),
                            propietario = findClientesByDni(rs.getCharacterStream("cliente_dni").toString())
                        )
                    )
                }
            }
        }
    }

    fun findClientesByDni(dni: String): Cliente {

        var item: Cliente? = null
        val sql = """
            SELECT * FROM cliente WHERE cliente_dni =?
        """.trimIndent()

        db.use {
            it.prepareStatement(sql).use { stm ->
                stm.setCharacterStream(1, dni.reader())
                val rs = stm.executeQuery()
                rs?.let {
                    while (it.next()) {
                        item = Cliente(
                            dni = rs.getCharacterStream("cliente_dni").toString(),
                            nombre = rs.getCharacterStream("cliente_nombre").toString(),
                            apellidos = rs.getCharacterStream("cliente_apellido").toString(),
                            telefonoCliente = rs.getInt("cliente_telefono"),
                            correoCliente = rs.getCharacterStream("cliente_correo").toString()
                        )
                    }
                }
            }
        }
        return item!!
    }
}