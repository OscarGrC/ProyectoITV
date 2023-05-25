-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.0.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla itvdatabase.cita: ~0 rows (aproximadamente)
DELETE FROM `cita`;
INSERT INTO `cita` (`cita_id`, `vehiculo_matricula`, `trabajador_usuario`, `cita_fecha`, `cita_hora`) VALUES
	('03062027-a788-4853-aa7d-66145f15b4b9', '6666HHH', 'int1', '2023-05-18', ''),
	('049e38ac-c99f-4648-98b1-8567f0ce106c', '7777III', 'int2', '2023-05-18', ''),
	('11365d3b-9bf4-49a0-a6e9-da355b2f1fd4', '6655TTT', 'int1', '2023-05-18', ''),
	('1a2b3c4d-5e6f-4a3b-8c2d-1e3f4a5b6c7d', '2345KJH', 'int1', '2023-05-18', ''),
	('1af4d82a-d0f2-4478-8b1f-460c5e542783', '3344MMM', 'elec1', '2023-05-18', ''),
	('2221617a-7827-4221-936a-3d566981433d', '5566NNN', 'elec2', '2023-05-18', ''),
	('24e637c5-fe7e-440a-be5a-8b475cbf9c94', '8888JJJ', 'mec3', '2023-05-18', ''),
	('2d1e3c4b-98a7-4d5f-b6c0-9e8f7a6d5c4b', '3456NJH', 'mec2', '2023-05-18', ''),
	('2f468d30-5ae3-4384-9cd9-c7f376d3decd', '4321DCV', 'mec2', '2023-05-18', ''),
	('378532d5-d833-4dbc-8a24-8b75c1a19dbf', '6789MNO', 'motor1', '2023-05-18', ''),
	('3c4b5a6d-7890-4f21-b5a8-9c7d8e6f5a4b', '6789CVB', 'mec1', '2023-05-18', ''),
	('3d746ec5-e093-48a7-807d-c7022712cdf0', '5555GGG', 'mec2', '2023-05-18', ''),
	('45b6a798-e4d3-412f-b7c8-96e3f2d1c0b9', '7654VFR', 'motor2', '2023-05-18', ''),
	('4b5e7d76-c5ce-41cc-82ce-3701a5489a5f', '4444FFF', 'mec1', '2023-05-18', ''),
	('65aa987b-345d-4f2b-9a1c-50bd03fd8e9c', '6543FVB', 'mec1', '2023-05-18', ''),
	('65e502d5-5cb5-4dd1-9ce0-b4e32bba1d9d', '7788PPP', 'motor1', '2023-05-18', ''),
	('7763cf5c-3777-4c71-85f1-f53ee5269d43', '9000QQQ', 'motor2', '2023-05-18', ''),
	('7e55cd0a-123d-4568-8907-89a4c67524f2', '2345DFG', 'elec2', '2023-05-18', ''),
	('8116633d-5e03-4305-a35a-c731abd1f2d0', '4433SSS', 'mec2', '2023-05-18', ''),
	('88753a02-9471-4610-9ebb-cfaf451acd78', '2211RRR', 'mec1', '2023-05-18', ''),
	('8eb6816c-7ce3-49dc-8557-25cc0c60009d', '9876FGH', 'motor1', '2023-05-18', ''),
	('9f1e85f3-9ae5-46ae-8a1d-01a4d6f7d906', '9876BGH', 'elec1', '2023-05-18', ''),
	('a44346ac-6e2b-4379-8b4f-1b325074a14f', '4321ZYX', 'motor2', '2023-05-18', ''),
	('a9c3d456-87e5-42b1-98c1-34ed2507db29', '8907NHY', 'int2', '2023-05-18', ''),
	('aa85bc3f-7f4d-4962-89e6-3cd4596df8a7', '8907DFG', 'motor1', '2023-05-18', ''),
	('b4e59c23-fd5e-4f21-9d8a-9e07a4097c8f', '5432BGT', 'int1', '2023-05-18', ''),
	('b7c0d84e-e83e-4172-aded-6448281af27e', '1234ABC', 'elec1', '2023-05-18', ''),
	('d0c9b8a7-321d-4e87-9c65-4b5a3f2e1d0c', '8765TGB', 'motor1', '2023-05-18', ''),
	('d9b0412c-7b11-4cd8-9485-41cc97fd3cf1', '3455HHF', 'motor1', '2023-05-18', ''),
	('d9b0472b-7b11-4cd8-9485-41cc97fd3cf1', '4564JKK', 'motor1', '2023-05-18', ''),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf2', '4567JKL', 'motor1', '2023-05-18', ''),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf3', '2345SDF', 'elec1', '2023-05-18', ''),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf4', '8765CVB', 'mec1', '2023-05-18', ''),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf5', '5432NHY', 'int1', '2023-05-18', ''),
	('e12d31cc-6958-4cae-ab62-ae2ed2bb2d35', '1122LLL', 'int2', '2023-05-18', ''),
	('e5d9c84a-432a-4b47-a1a0-287e89370e72', '8765JKL', 'motor2', '2023-05-18', ''),
	('e6026487-0aa8-4de6-8a21-14e437d32c65', '4567GHI', 'elec2', '2023-05-18', ''),
	('e6d5c4b3-45f2-4d1a-a987-6701e23a4f5d', '3210FDS', 'elec2', '2023-05-18', ''),
	('e8c9a1b0-6f23-4a1b-892e-0c34ed8d3a45', '7890MNB', 'elec1', '2023-05-18', ''),
	('ff3a0f3e-de06-4b49-8af8-782d5d8a3ed7', '9999KKK', 'int1', '2023-05-18', '');

-- Volcando datos para la tabla itvdatabase.cliente: ~40 rows (aproximadamente)
DELETE FROM `cliente`;
INSERT INTO `cliente` (`cliente_dni`, `cliente_nombre`, `cliente_apellidos`, `cliente_telefono`, `cliente_correo`) VALUES
	('01233567J', 'Elena', 'Hernández', 635317025, 'elena@gmail.com'),
	('01234567T', 'Lucía', 'Guerrero', 635317035, 'lucia@gmail.com'),
	('02521164L', 'Laura', 'Pérez', 612345682, 'luisperez5@gmail.com'),
	('07756995S', 'Jorge', 'Soto', 612345691, 'carmensoto14@gmail.com'),
	('12343678K', 'Pablo', 'Navarro', 635317026, 'pablo@gmail.com'),
	('12345673A', 'Juan', 'Gómez', 635317016, 'juan@gmail.com'),
	('13993569R', 'Luis', 'Rodríguez', 612345681, 'anarodriguez4@gmail.com'),
	('23296244G', 'Ricardo', 'Vargas', 612345693, 'silviavargas16@gmail.com'),
	('23453289L', 'Isabel', 'Jiménez', 635317027, 'isabel@gmail.com'),
	('23456389B', 'María', 'López', 635317017, 'maria@gmail.com'),
	('30759782L', 'Marcos', 'Gómez', 612345678, 'juangomez1@gmail.com'),
	('30922853C', 'Ahinoa', 'Morales', 612345690, 'ricardomorales13@gmail.com'),
	('34533890M', 'Ricardo', 'Morales', 635317028, 'ricardo@gmail.com'),
	('34567490C', 'Pedro', 'Fernández', 635317018, 'pedro@gmail.com'),
	('45308168P', 'Laura', 'González', 612345683, 'lauragonzalez6@gmail.com'),
	('45633901N', 'Carmen', 'Soto', 635317029, 'carmen@gmail.com'),
	('45678401D', 'Ana', 'Rodríguez', 635317019, 'ana@gmail.com'),
	('53063737T', 'Pablo', 'Ramírez', 612345685, 'sofiaramirez8@gmail.com'),
	('54894439V', 'Edison', 'Delgado', 612345696, 'gabrieldelgado19@gmail.com'),
	('56782012O', 'Jorge', 'Ortega', 635317030, 'jorge@gmail.com'),
	('56789412E', 'Luis', 'Pérez', 635317020, 'luis@gmail.com'),
	('56792012O', 'Arturo', 'Ortega', 612345692, 'jorgeortega15@gmail.com'),
	('60123345I', 'Elena', 'Sánchez', 612345686, 'miguelsanchez9@gmail.com'),
	('61914500H', 'Alumno', 'McPreguntita', 612345697, 'luckherrero20@gmail.com'),
	('63120171Y', 'Pedro', 'López', 612345679, 'marialopez2@gmail.com'),
	('65001638G', 'Sofía', 'Torres', 612345684, 'carlostorres7@gmail.com'),
	('66035071R', 'Patrik', 'Castillo', 612345695, 'patriciacastillo18@gmail.com'),
	('67890423F', 'Laura', 'González', 635317021, 'laura@gmail.com'),
	('67892123P', 'Silvia', 'Vargas', 635317031, 'silvia@gmail.com'),
	('78719473H', 'ROberta', 'Molina', 612345694, 'robertomolina17@gmail.com'),
	('78901234Q', 'Roberto', 'Molina', 635317032, 'roberto@gmail.com'),
	('78901434G', 'Carlos', 'Torres', 635317022, 'carlos@gmail.com'),
	('85490048Z', 'Ana', 'Fernández', 612345680, 'pedrofernandez3@gmail.com'),
	('87544179S', 'Gorka', 'Navarro', 612345688, 'pablonavarro11@gmail.com'),
	('89011345R', 'Patricia', 'Castillo', 635317033, 'patricia@gmail.com'),
	('89012345H', 'Sofía', 'Ramírez', 635317023, 'sofia@gmail.com'),
	('90121456S', 'Gabriel', 'Delgado', 635317034, 'gabriel@gmail.com'),
	('90123345I', 'Miguel', 'Sánchez', 635317024, 'miguel@gmail.com'),
	('91113518F', 'Pilar', 'Hernández', 612345687, 'elenahernandez10@gmail.com'),
	('95856737M', 'Aitor', 'Jiménez', 612345689, 'isabeljimenez12@gmail.com');

-- Volcando datos para la tabla itvdatabase.estacion: ~2 rows (aproximadamente)
DELETE FROM `estacion`;
INSERT INTO `estacion` (`estacion_id`, `estacion_nombre`, `estacion_direccion`, `estacion_telefono`, `estacion_correo`) VALUES
	('EST001', 'Estación A', 'Calle Principal 12 3D', '123456789', 'estaciona@example.com'),
	('EST002', 'Estación B', 'Avenida Secundaria 45', '987654321', 'estacionb@example.com');

-- Volcando datos para la tabla itvdatabase.trabajador: ~11 rows (aproximadamente)
DELETE FROM `trabajador`;
INSERT INTO `trabajador` (`trabajador_usuario`, `trabajador_nombre`, `trabajador_telefono`, `trabajador_email`, `trabajador_fecha_contrato`, `trabajador_contraseña`, `trabajador_tipo`, `trabajador_plus_direccion`, `trabajador_sueldo`, `estacion_id`) VALUES
	('admin1', 'Juan Pérez', 612345678, 'juanperez@example.com', '2020-01-01', 'contraseña1', 'ADMINISTRACION', 0, 1750, 'EST001'),
	('admin2', 'Ana Gómez', 623456789, 'anagomez@example.com', '2018-03-15', 'contraseña2', 'ADMINISTRACION', 0, 1750, 'EST001'),
	('elec1', 'Carlos Rodríguez', 634567890, 'carlosrodriguez@example.com', '2019-05-28', 'contraseña3', 'ELECTRICIDAD', 0, 1900, 'EST001'),
	('elec2', 'María Torres', 645678901, 'mariatorres@example.com', '2017-09-12', 'contraseña4', 'ELECTRICIDAD', 0, 1900, 'EST001'),
	('int1', 'Javier Martínez', 690123456, 'javiermartinez@example.com', '2016-08-10', 'contraseña9', 'INTERIOR', 0, 1950, 'EST001'),
	('int2', 'Sofía García', 601234567, 'sofiagarcia@example.com', '2014-10-23', 'contraseña10', 'INTERIOR', 0, 1950, 'EST001'),
	('mec1', 'Pedro Ramírez', 678901234, 'pedroramirez@example.com', '2017-03-17', 'contraseña7', 'MECANICA', 0, 1800, 'EST001'),
	('mec2', 'Marta López', 689012345, 'martalopez@example.com', '2015-05-28', 'contraseña8', 'MECANICA', 0, 1800, 'EST001'),
	('mec3', 'David Sánchez', 612345678, 'davidsanchez@example.com', '2015-12-31', 'contraseña11', 'MECANICA', 1, 2800, 'EST001'),
	('motor1', 'Luis Fernández', 656789012, 'luisfernandez@example.com', '2018-11-24', 'contraseña5', 'MOTOR', 0, 1800, 'EST001'),
	('motor2', 'Laura Silva', 667890123, 'laurasilva@example.com', '2016-01-03', 'contraseña6', 'MOTOR', 0, 1900, 'EST001');

-- Volcando datos para la tabla itvdatabase.valorespruebas: ~40 rows (aproximadamente)
DELETE FROM `valorespruebas`;
INSERT INTO `valorespruebas` (`cita_id`, `informe_favorable`, `informe_frenado`, `informe_contaminacion`, `informe_interior`, `informe_luces`) VALUES
	('03062027-a788-4853-aa7d-66145f15b4b9', 1, 6.01, 39.12, 1, 1),
	('049e38ac-c99f-4648-98b1-8567f0ce106c', 1, 9.88, 22.55, 1, 1),
	('11365d3b-9bf4-49a0-a6e9-da355b2f1fd4', 1, 3.45, 34.76, 1, 1),
	('1a2b3c4d-5e6f-4a3b-8c2d-1e3f4a5b6c7d', 0, 9.45, 59.87, 1, 1),
	('1af4d82a-d0f2-4478-8b1f-460c5e542783', 1, 4.23, 37.42, 1, 1),
	('2221617a-7827-4221-936a-3d566981433d', 1, 9.12, 23.87, 1, 1),
	('24e637c5-fe7e-440a-be5a-8b475cbf9c94', 1, 5.76, 45.23, 1, 1),
	('2d1e3c4b-98a7-4d5f-b6c0-9e8f7a6d5c4b', 1, 7.91, 46.78, 1, 1),
	('2f468d30-5ae3-4384-9cd9-c7f376d3decd', 1, 5.76, 37.89, 1, 1),
	('378532d5-d833-4dbc-8a24-8b75c1a19dbf', 1, 6.89, 35.27, 1, 1),
	('3c4b5a6d-7890-4f21-b5a8-9c7d8e6f5a4b', 1, 6.78, 45.67, 1, 1),
	('3d746ec5-e093-48a7-807d-c7022712cdf0', 1, 7.33, 25.94, 1, 1),
	('45b6a798-e4d3-412f-b7c8-96e3f2d1c0b9', 1, 7.32, 52.34, 1, 1),
	('4b5e7d76-c5ce-41cc-82ce-3701a5489a5f', 1, 4.79, 42.37, 1, 1),
	('65aa987b-345d-4f2b-9a1c-50bd03fd8e9c', 1, 7.94, 48.76, 1, 1),
	('65e502d5-5cb5-4dd1-9ce0-b4e32bba1d9d', 1, 6.67, 46.29, 1, 1),
	('7763cf5c-3777-4c71-85f1-f53ee5269d43', 1, 8.43, 26.35, 1, 1),
	('7e55cd0a-123d-4568-8907-89a4c67524f2', 0, 8.71, 79.24, 1, 1),
	('8116633d-5e03-4305-a35a-c731abd1f2d0', 0, 7.21, 30.14, 1, 0),
	('88753a02-9471-4610-9ebb-cfaf451acd78', 1, 5.99, 41.58, 1, 1),
	('8eb6816c-7ce3-49dc-8557-25cc0c60009d', 1, 5.21, 43.12, 1, 1),
	('9f1e85f3-9ae5-46ae-8a1d-01a4d6f7d906', 1, 5.42, 42.68, 1, 1),
	('a44346ac-6e2b-4379-8b4f-1b325074a14f', 1, 8.12, 29.81, 1, 1),
	('a9c3d456-87e5-42b1-98c1-34ed2507db29', 1, 7.15, 51.24, 1, 1),
	('aa85bc3f-7f4d-4962-89e6-3cd4596df8a7', 1, 6.29, 53.12, 1, 1),
	('b4e59c23-fd5e-4f21-9d8a-9e07a4097c8f', 0, 18.22, 42.53, 1, 1),
	('b7c0d84e-e83e-4172-aded-6448281af27e', 1, 3.76, 27.43, 1, 1),
	('d0c9b8a7-321d-4e87-9c65-4b5a3f2e1d0c', 0, 8.95, 35.67, 0, 1),
	('d9b0412c-7b11-4cd8-9485-41cc97fd3cf1', 1, 7.85, 32.76, 1, 1),
	('d9b0472b-7b11-4cd8-9485-41cc97fd3cf1', 1, 7.85, 32.76, 1, 1),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf2', 1, 7.15, 51.24, 1, 1),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf3', 0, 9.01, 38.76, 0, 0),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf4', 1, 7.83, 47.92, 1, 1),
	('d9t0412b-7b11-4cd8-9485-41cc97fd3cf5', 0, 8.95, 35.67, 0, 1),
	('e12d31cc-6958-4cae-ab62-ae2ed2bb2d35', 0, 6.55, 31.68, 0, 1),
	('e5d9c84a-432a-4b47-a1a0-287e89370e72', 0, 9.63, 28.45, 0, 1),
	('e6026487-0aa8-4de6-8a21-14e437d32c65', 1, 9.45, 48.93, 1, 1),
	('e6d5c4b3-45f2-4d1a-a987-6701e23a4f5d', 1, 7.83, 47.92, 1, 1),
	('e8c9a1b0-6f23-4a1b-892e-0c34ed8d3a45', 0, 9.01, 38.76, 0, 0),
	('ff3a0f3e-de06-4b49-8af8-782d5d8a3ed7', 0, 7.99, 28.77, 1, 0);

-- Volcando datos para la tabla itvdatabase.vehiculo: ~40 rows (aproximadamente)
DELETE FROM `vehiculo`;
INSERT INTO `vehiculo` (`vehiculo_matricula`, `vehiculo_marca`, `vehiculo_modelo`, `vehiculo_fechaMatriculacion`, `vehiculo_fechaUltimaRevision`, `vehiculo_tipo_Motor`, `vehiculo_tipo_Vehiculo`, `vehiculo_imagen`, `vehiculo_propietario`) VALUES
	('1122LLL', 'Renault', 'Mégane', '2001-03-28', '2023-03-28', 'DIESEL', 'TURISMO', NULL, '34533890M'),
	('1234ABC', 'Renault', 'Clio', '2010-05-28', '2022-05-28', 'DIESEL', 'TURISMO', NULL, '34567490C'),
	('2211RRR', 'Volkswagen', 'Polo', '2006-03-30', '2023-03-30', 'DIESEL', 'TURISMO', NULL, '89011345R'),
	('2345DFG', 'Ford', 'Focus', '2015-05-20', '2023-05-20', 'DIESEL', 'TURISMO', NULL, '85490048Z'),
	('2345KJH', 'Kawasaki', 'Ninja 650', '2018-12-25', '2023-12-25', 'GASOLINA', 'MOTO', NULL, '56792012O'),
	('2345SDF', 'Ford', 'Mustang', '2017-11-25', '2023-11-25', 'GASOLINA', 'TURISMO', NULL, '66035071R'),
	('3210FDS', 'Mercedes-Benz', 'Sprinter', '2013-02-15', '2023-02-15', 'DIESEL', 'FURGONETA', NULL, '91113518F'),
	('3344MMM', 'Ford', 'Mondeo', '2000-06-10', '2022-06-10', 'DIESEL', 'TURISMO', NULL, '45633901N'),
	('3455HHF', 'Renault', 'Clio', '2012-01-01', '2023-01-01', 'GASOLINA', 'TURISMO', NULL, '30759782L'),
	('3456NJH', 'Yamaha', 'YZF-R6', '2017-08-20', '2023-08-20', 'GASOLINA', 'MOTO', NULL, '07756995S'),
	('4321DCV', 'Peugeot', '208', '2016-11-25', '2023-11-25', 'GASOLINA', 'TURISMO', NULL, '45308168P'),
	('4321ZYX', 'BMW', 'Serie 1', '2007-01-03', '2023-01-03', 'GASOLINA', 'TURISMO', NULL, '67890423F'),
	('4433SSS', 'Renault', 'Kangoo', '2005-06-11', '2022-06-11', 'DIESEL', 'FURGONETA', NULL, '90121456S'),
	('4444FFF', 'Ford', 'Focus', '2006-03-17', '2023-03-17', 'DIESEL', 'TURISMO', NULL, '78901434G'),
	('4564JKK', 'Ford', 'Fiesta', '2012-01-01', '2023-01-01', 'GASOLINA', 'TURISMO', NULL, '12345673A'),
	('4567GHI', 'Audi', 'A3', '2009-09-12', '2022-09-12', 'GASOLINA', 'TURISMO', NULL, '45678401D'),
	('4567JKL', 'Toyota', 'Yaris', '2016-09-05', '2023-09-05', 'HÍBRIDO', 'TURISMO', NULL, '78719473H'),
	('5432BGT', 'Mercedes-Benz', 'Actros', '2010-03-10', '2023-03-10', 'DIESEL', 'CAMION', NULL, '65001638G'),
	('5432NHY', 'Seat', 'Leon', '2019-07-05', '2023-07-05', 'GASOLINA', 'TURISMO', NULL, '61914500H'),
	('5555GGG', 'Toyota', 'Yaris', '2005-05-28', '2022-05-28', 'HIBRIDO', 'TURISMO', NULL, '89012345H'),
	('5566NNN', 'Opel', 'Astra', '2009-08-23', '2022-08-23', 'GASOLINA', 'TURISMO', NULL, '56782012O'),
	('6543FVB', 'Seat', 'Ibiza', '2013-09-05', '2023-09-05', 'GASOLINA', 'TURISMO', NULL, '02521164L'),
	('6655TTT', 'Ford', 'Transit', '2004-08-24', '2022-08-24', 'DIESEL', 'FURGONETA', NULL, '01234567T'),
	('6666HHH', 'Citroën', 'C3', '2004-08-10', '2022-08-10', 'DIESEL', 'TURISMO', NULL, '90123345I'),
	('6789CVB', 'Honda', 'CBR600RR', '2016-04-15', '2023-04-15', 'GASOLINA', 'MOTO', NULL, '30922853C'),
	('6789MNO', 'Peugeot', '208', '2008-11-24', '2022-11-24', 'GASOLINA', 'TURISMO', NULL, '56789412E'),
	('7654VFR', 'Ford', 'Transit', '2015-10-05', '2023-10-05', 'DIESEL', 'FURGONETA', NULL, '95856737M'),
	('7777III', 'Seat', 'Ibiza', '2003-10-23', '2022-10-23', 'GASOLINA', 'TURISMO', NULL, '01233567J'),
	('7788PPP', 'Mercedes-Benz', 'Clase A', '2008-11-04', '2022-11-04', 'DIESEL', 'TURISMO', NULL, '67892123P'),
	('7890MNB', 'Scania', 'R-Series', '2012-11-20', '2023-11-20', 'DIESEL', 'CAMION', NULL, '60123345I'),
	('8765CVB', 'Volkswagen', 'Tiguan', '2018-03-10', '2023-03-10', 'DIESEL', 'TURISMO', NULL, '54894439V'),
	('8765JKL', 'Volkswagen', 'Golf', '2014-07-10', '2023-07-10', 'GASOLINA', 'TURISMO', NULL, '13993569R'),
	('8765TGB', 'Volkswagen', 'Transporter', '2014-06-30', '2023-06-30', 'DIESEL', 'FURGONETA', NULL, '87544179S'),
	('8888JJJ', 'Opel', 'Corsa', '2002-12-31', '2022-12-31', 'DIESEL', 'TURISMO', NULL, '12343678K'),
	('8907DFG', 'Renault', 'Megane', '2015-07-10', '2023-07-10', 'GASOLINA', 'TURISMO', NULL, '23296244G'),
	('8907NHY', 'Volvo', 'FH', '2011-07-05', '2023-07-05', 'DIESEL', 'CAMION', NULL, '53063737T'),
	('9000QQQ', 'BMW', 'X1', '2007-01-17', '2022-01-17', 'GASOLINA', 'TURISMO', NULL, '78901234Q'),
	('9876BGH', 'Toyota', 'Corolla', '2011-03-15', '2023-03-15', 'HIBRIDO', 'TURISMO', NULL, '63120171Y'),
	('9876FGH', 'Toyota', 'Corolla', '2011-03-15', '2023-03-15', 'HIBRIDO', 'TURISMO', NULL, '23456389B'),
	('9999KKK', 'Volkswagen', 'Golf', '2002-01-15', '2023-01-15', 'GASOLINA', 'TURISMO', NULL, '23453289L');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
