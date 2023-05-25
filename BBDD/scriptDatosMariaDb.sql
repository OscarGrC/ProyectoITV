
-- Ahora insertamos valores 

INSERT INTO cliente (cliente_dni, cliente_nombre, cliente_apellidos, cliente_telefono, cliente_correo)
VALUES
    ('12345673A', 'Juan', 'Gómez', 635317016, 'juan@gmail.com'),
    ('23456389B', 'María', 'López', 635317017, 'maria@gmail.com'),
    ('34567490C', 'Pedro', 'Fernández', 635317018, 'pedro@gmail.com'),
    ('45678401D', 'Ana', 'Rodríguez', 635317019, 'ana@gmail.com'),
    ('56789412E', 'Luis', 'Pérez', 635317020, 'luis@gmail.com'),
    ('67890423F', 'Laura', 'González', 635317021, 'laura@gmail.com'),
    ('78901434G', 'Carlos', 'Torres', 635317022, 'carlos@gmail.com'),
    ('89012345H', 'Sofía', 'Ramírez', 635317023, 'sofia@gmail.com'),
    ('90123345I', 'Miguel', 'Sánchez', 635317024, 'miguel@gmail.com'),
    ('01233567J', 'Elena', 'Hernández', 635317025, 'elena@gmail.com'),
    ('12343678K', 'Pablo', 'Navarro', 635317026, 'pablo@gmail.com'),
    ('23453289L', 'Isabel', 'Jiménez', 635317027, 'isabel@gmail.com'),
    ('34533890M', 'Ricardo', 'Morales', 635317028, 'ricardo@gmail.com'),
    ('45633901N', 'Carmen', 'Soto', 635317029, 'carmen@gmail.com'),
    ('56782012O', 'Jorge', 'Ortega', 635317030, 'jorge@gmail.com'),
    ('67892123P', 'Silvia', 'Vargas', 635317031, 'silvia@gmail.com'),
    ('78901234Q', 'Roberto', 'Molina', 635317032, 'roberto@gmail.com'),
    ('89011345R', 'Patricia', 'Castillo', 635317033, 'patricia@gmail.com'),
    ('90121456S', 'Gabriel', 'Delgado', 635317034, 'gabriel@gmail.com'),
    ('01234567T', 'Lucía', 'Guerrero', 635317035, 'lucia@gmail.com'),
	('30759782L', 'Marcos', 'Gómez', 612345678, 'juangomez1@gmail.com'),
    ('63120171Y', 'Pedro', 'López', 612345679, 'marialopez2@gmail.com'),
    ('85490048Z', 'Ana', 'Fernández', 612345680, 'pedrofernandez3@gmail.com'),
    ('13993569R', 'Luis', 'Rodríguez', 612345681, 'anarodriguez4@gmail.com'),
    ('02521164L', 'Laura', 'Pérez', 612345682, 'luisperez5@gmail.com'),
    ('45308168P', 'Laura', 'González', 612345683, 'lauragonzalez6@gmail.com'),
    ('65001638G', 'Sofía', 'Torres', 612345684, 'carlostorres7@gmail.com'),
    ('53063737T', 'Pablo', 'Ramírez', 612345685, 'sofiaramirez8@gmail.com'),
    ('60123345I', 'Elena', 'Sánchez', 612345686, 'miguelsanchez9@gmail.com'),
    ('91113518F', 'Pilar', 'Hernández', 612345687, 'elenahernandez10@gmail.com'),
    ('87544179S', 'Gorka', 'Navarro', 612345688, 'pablonavarro11@gmail.com'),
    ('95856737M', 'Aitor', 'Jiménez', 612345689, 'isabeljimenez12@gmail.com'),
    ('30922853C', 'Ahinoa', 'Morales', 612345690, 'ricardomorales13@gmail.com'),
    ('07756995S', 'Jorge', 'Soto', 612345691, 'carmensoto14@gmail.com'),
    ('56792012O', 'Arturo', 'Ortega', 612345692, 'jorgeortega15@gmail.com'),
    ('23296244G', 'Ricardo', 'Vargas', 612345693, 'silviavargas16@gmail.com'),
    ('78719473H', 'ROberta', 'Molina', 612345694, 'robertomolina17@gmail.com'),
    ('66035071R', 'Patrik', 'Castillo', 612345695, 'patriciacastillo18@gmail.com'),
    ('54894439V', 'Edison', 'Delgado', 612345696, 'gabrieldelgado19@gmail.com'),
    ('61914500H', 'Alumno', 'McPreguntita', 612345697, 'luckherrero20@gmail.com');

    INSERT INTO vehiculo (vehiculo_matricula, vehiculo_marca, vehiculo_modelo, vehiculo_fechaMatriculacion, vehiculo_fechaUltimaRevision, vehiculo_tipo_Motor, vehiculo_tipo_Vehiculo,vehiculo_imagen, vehiculo_propietario)
VALUES
    ('4564JKK', 'Ford', 'Fiesta', '2012-01-01', '2023-01-01', 'GASOLINA', 'TURISMO',null, '12345673A'),
    ('9876FGH', 'Toyota', 'Corolla', '2011-03-15', '2023-03-15', 'HIBRIDO', 'TURISMO',null, '23456389B'),
    ('1234ABC', 'Renault', 'Clio', '2010-05-28', '2022-05-28', 'DIESEL', 'TURISMO',null, '34567490C'),
    ('4567GHI', 'Audi', 'A3', '2009-09-12', '2022-09-12', 'GASOLINA', 'TURISMO',null, '45678401D'),
    ('6789MNO', 'Peugeot', '208', '2008-11-24', '2022-11-24', 'GASOLINA', 'TURISMO',null, '56789412E'),
    ('4321ZYX', 'BMW', 'Serie 1', '2007-01-03', '2023-01-03', 'GASOLINA', 'TURISMO',null, '67890423F'),
    ('4444FFF', 'Ford', 'Focus', '2006-03-17', '2023-03-17', 'DIESEL', 'TURISMO',null, '78901434G'),
    ('5555GGG', 'Toyota', 'Yaris', '2005-05-28', '2022-05-28', 'HIBRIDO', 'TURISMO',null, '89012345H'),
    ('6666HHH', 'Citroën', 'C3', '2004-08-10', '2022-08-10', 'DIESEL', 'TURISMO',null, '90123345I'),
    ('7777III', 'Seat', 'Ibiza', '2003-10-23', '2022-10-23', 'GASOLINA', 'TURISMO',null, '01233567J'),
    ('8888JJJ', 'Opel', 'Corsa', '2002-12-31', '2022-12-31', 'DIESEL', 'TURISMO',null, '12343678K'),
    ('9999KKK', 'Volkswagen', 'Golf', '2002-01-15', '2023-01-15', 'GASOLINA', 'TURISMO',null, '23453289L'),
    ('1122LLL', 'Renault', 'Mégane', '2001-03-28', '2023-03-28', 'DIESEL', 'TURISMO',null, '34533890M'),
    ('3344MMM', 'Ford', 'Mondeo', '2000-06-10', '2022-06-10', 'DIESEL', 'TURISMO',null, '45633901N'),
    ('5566NNN', 'Opel', 'Astra', '2009-08-23', '2022-08-23', 'GASOLINA', 'TURISMO',null, '56782012O'),
    ('7788PPP', 'Mercedes-Benz', 'Clase A', '2008-11-04', '2022-11-04', 'DIESEL', 'TURISMO',null, '67892123P'),
    ('9000QQQ', 'BMW', 'X1', '2007-01-17', '2022-01-17', 'GASOLINA', 'TURISMO',null, '78901234Q'),
    ('2211RRR', 'Volkswagen', 'Polo', '2006-03-30', '2023-03-30', 'DIESEL', 'TURISMO',null, '89011345R'),
    ('4433SSS', 'Renault', 'Kangoo', '2005-06-11', '2022-06-11', 'DIESEL', 'FURGONETA',null, '90121456S'),
    ('6655TTT', 'Ford', 'Transit', '2004-08-24', '2022-08-24', 'DIESEL', 'FURGONETA',null, '01234567T'),
    ('3455HHF', 'Renault', 'Clio', '2012-01-01', '2023-01-01', 'GASOLINA', 'TURISMO',null, '30759782L'),
    ('9876BGH', 'Toyota', 'Corolla', '2011-03-15', '2023-03-15', 'HIBRIDO', 'TURISMO',null, '63120171Y'),
    ('2345DFG', 'Ford', 'Focus', '2015-05-20', '2023-05-20', 'DIESEL', 'TURISMO',null, '85490048Z'),
    ('8765JKL', 'Volkswagen', 'Golf', '2014-07-10', '2023-07-10', 'GASOLINA', 'TURISMO',null, '13993569R'),
    ('6543FVB', 'Seat', 'Ibiza', '2013-09-05', '2023-09-05', 'GASOLINA', 'TURISMO',null, '02521164L'),
    ('4321DCV', 'Peugeot', '208', '2016-11-25', '2023-11-25', 'GASOLINA', 'TURISMO',null, '45308168P'),
    ('5432BGT', 'Mercedes-Benz', 'Actros', '2010-03-10', '2023-03-10', 'DIESEL', 'CAMION',null, '65001638G'),
    ('8907NHY', 'Volvo', 'FH', '2011-07-05', '2023-07-05', 'DIESEL', 'CAMION',null, '53063737T'),
    ('7890MNB', 'Scania', 'R-Series', '2012-11-20', '2023-11-20', 'DIESEL', 'CAMION',null, '60123345I'),
    ('3210FDS', 'Mercedes-Benz', 'Sprinter', '2013-02-15', '2023-02-15', 'DIESEL', 'FURGONETA',null, '91113518F'),
    ('8765TGB', 'Volkswagen', 'Transporter', '2014-06-30', '2023-06-30', 'DIESEL', 'FURGONETA',null, '87544179S'),
    ('7654VFR', 'Ford', 'Transit', '2015-10-05', '2023-10-05', 'DIESEL', 'FURGONETA',null, '95856737M'),
    ('6789CVB', 'Honda', 'CBR600RR', '2016-04-15', '2023-04-15', 'GASOLINA', 'MOTO',null, '30922853C'),
    ('3456NJH', 'Yamaha', 'YZF-R6', '2017-08-20', '2023-08-20', 'GASOLINA', 'MOTO',null, '07756995S'),
    ('2345KJH', 'Kawasaki', 'Ninja 650', '2018-12-25', '2023-12-25', 'GASOLINA', 'MOTO',null, '56792012O'),    
	('8907DFG', 'Renault', 'Megane', '2015-07-10', '2023-07-10', 'GASOLINA', 'TURISMO',null,'23296244G'),
	('4567JKL', 'Toyota', 'Yaris', '2016-09-05', '2023-09-05', 'HÍBRIDO', 'TURISMO',null,'78719473H'),
    ('2345SDF', 'Ford', 'Mustang', '2017-11-25', '2023-11-25', 'GASOLINA', 'TURISMO',null,'66035071R'),
	('8765CVB', 'Volkswagen', 'Tiguan', '2018-03-10', '2023-03-10', 'DIESEL', 'TURISMO',null,'54894439V'),
	('5432NHY', 'Seat', 'Leon', '2019-07-05', '2023-07-05', 'GASOLINA', 'TURISMO',null,'61914500H');



INSERT INTO estacion (estacion_id, estacion_nombre, estacion_direccion, estacion_telefono, estacion_correo)
VALUES
('EST001', 'Estación A', 'Calle Principal 12 3D', '123456789', 'estaciona@example.com'),
('EST002', 'Estación B', 'Avenida Secundaria 45', '987654321', 'estacionb@example.com');

INSERT INTO trabajador (trabajador_usuario, trabajador_nombre, trabajador_telefono, trabajador_email, trabajador_fecha_contrato, trabajador_contraseña, trabajador_tipo, trabajador_plus_direccion, trabajador_sueldo, estacion_id)
VALUES
('admin1', 'Juan Pérez', 612345678, 'juanperez@example.com', '2020-01-01', 'contraseña1', 'ADMINISTRACION', FALSE, 1750, 'EST001'),
('admin2', 'Ana Gómez', 623456789, 'anagomez@example.com', '2018-03-15', 'contraseña2', 'ADMINISTRACION', FALSE, 1750, 'EST001'),
('elec1', 'Carlos Rodríguez', 634567890, 'carlosrodriguez@example.com', '2019-05-28', 'contraseña3', 'ELECTRICIDAD', FALSE, 1900, 'EST001'),
('elec2', 'María Torres', 645678901, 'mariatorres@example.com', '2017-09-12', 'contraseña4', 'ELECTRICIDAD', FALSE, 1900, 'EST001'),
('motor1', 'Luis Fernández', 656789012, 'luisfernandez@example.com', '2018-11-24', 'contraseña5', 'MOTOR', FALSE, 1800, 'EST001'),
('motor2', 'Laura Silva', 667890123, 'laurasilva@example.com', '2016-01-03', 'contraseña6', 'MOTOR', FALSE, 1900, 'EST001'),
('mec1', 'Pedro Ramírez', 678901234, 'pedroramirez@example.com', '2017-03-17', 'contraseña7', 'MECANICA', FALSE, 1800, 'EST001'),
('mec2', 'Marta López', 689012345, 'martalopez@example.com', '2015-05-28', 'contraseña8', 'MECANICA', FALSE, 1800, 'EST001'),
('int1', 'Javier Martínez', 690123456, 'javiermartinez@example.com', '2016-08-10', 'contraseña9', 'INTERIOR', FALSE, 1950, 'EST001'),
('int2', 'Sofía García', 601234567, 'sofiagarcia@example.com', '2014-10-23', 'contraseña10', 'INTERIOR', FALSE, 1950, 'EST001'),
('mec3', 'David Sánchez', 612345678, 'davidsanchez@example.com', '2015-12-31', 'contraseña11', 'MECANICA', TRUE, 2800, 'EST001');

INSERT INTO cita (cita_id, vehiculo_matricula, trabajador_usuario, cita_fecha)
VALUES
('d9b0472b-7b11-4cd8-9485-41cc97fd3cf1', '4564JKK', 'motor1', '2023-05-18 10:00:00'),
('8eb6816c-7ce3-49dc-8557-25cc0c60009d', '9876FGH', 'motor1', '2023-05-18 10:30:00'),
('b7c0d84e-e83e-4172-aded-6448281af27e', '1234ABC', 'elec1', '2023-05-18 11:00:00'),
('e6026487-0aa8-4de6-8a21-14e437d32c65', '4567GHI', 'elec2', '2023-05-18 11:30:00'),
('378532d5-d833-4dbc-8a24-8b75c1a19dbf', '6789MNO', 'motor1', '2023-05-18 12:00:00'),
('a44346ac-6e2b-4379-8b4f-1b325074a14f', '4321ZYX', 'motor2', '2023-05-18 12:30:00'),
('4b5e7d76-c5ce-41cc-82ce-3701a5489a5f', '4444FFF', 'mec1', '2023-05-18 13:00:00'),
('3d746ec5-e093-48a7-807d-c7022712cdf0', '5555GGG', 'mec2', '2023-05-18 13:30:00'),
('03062027-a788-4853-aa7d-66145f15b4b9', '6666HHH', 'int1', '2023-05-18 14:00:00'),
('049e38ac-c99f-4648-98b1-8567f0ce106c', '7777III', 'int2', '2023-05-18 14:30:00'),
('24e637c5-fe7e-440a-be5a-8b475cbf9c94', '8888JJJ', 'mec3', '2023-05-18 15:00:00'),
('ff3a0f3e-de06-4b49-8af8-782d5d8a3ed7', '9999KKK', 'int1', '2023-05-18 15:30:00'),
('e12d31cc-6958-4cae-ab62-ae2ed2bb2d35', '1122LLL', 'int2', '2023-05-18 16:00:00'),
('1af4d82a-d0f2-4478-8b1f-460c5e542783', '3344MMM', 'elec1', '2023-05-18 16:30:00'),
('2221617a-7827-4221-936a-3d566981433d', '5566NNN', 'elec2', '2023-05-18 17:00:00'),
('65e502d5-5cb5-4dd1-9ce0-b4e32bba1d9d', '7788PPP', 'motor1', '2023-05-18 17:30:00'),
('7763cf5c-3777-4c71-85f1-f53ee5269d43', '9000QQQ', 'motor2', '2023-05-18 18:00:00'),
('88753a02-9471-4610-9ebb-cfaf451acd78', '2211RRR', 'mec1', '2023-05-18 18:30:00'),
('8116633d-5e03-4305-a35a-c731abd1f2d0', '4433SSS', 'mec2', '2023-05-18 19:00:00'),
('11365d3b-9bf4-49a0-a6e9-da355b2f1fd4', '6655TTT', 'int1', '2023-05-18 19:30:00'),
('d9b0412c-7b11-4cd8-9485-41cc97fd3cf1', '3455HHF', 'motor1', '2023-05-18 10:00:00'),
('9f1e85f3-9ae5-46ae-8a1d-01a4d6f7d906', '9876BGH', 'elec1', '2023-05-18 10:30:00'),
('7e55cd0a-123d-4568-8907-89a4c67524f2', '2345DFG', 'elec2', '2023-05-18 11:00:00'),
('aa85bc3f-7f4d-4962-89e6-3cd4596df8a7', '8907DFG', 'motor1', '2023-05-18 11:30:00'),
('e5d9c84a-432a-4b47-a1a0-287e89370e72', '8765JKL', 'motor2', '2023-05-18 12:00:00'),
('65aa987b-345d-4f2b-9a1c-50bd03fd8e9c', '6543FVB', 'mec1', '2023-05-18 12:30:00'),
('2f468d30-5ae3-4384-9cd9-c7f376d3decd', '4321DCV', 'mec2', '2023-05-18 13:00:00'),
('b4e59c23-fd5e-4f21-9d8a-9e07a4097c8f', '5432BGT', 'int1', '2023-05-18 13:30:00'),
('a9c3d456-87e5-42b1-98c1-34ed2507db29', '8907NHY', 'int2', '2023-05-18 14:00:00'),
('e8c9a1b0-6f23-4a1b-892e-0c34ed8d3a45', '7890MNB', 'elec1', '2023-05-18 14:30:00'),
('e6d5c4b3-45f2-4d1a-a987-6701e23a4f5d', '3210FDS', 'elec2', '2023-05-18 15:00:00'),
('d0c9b8a7-321d-4e87-9c65-4b5a3f2e1d0c', '8765TGB', 'motor1', '2023-05-18 15:30:00'),
('45b6a798-e4d3-412f-b7c8-96e3f2d1c0b9', '7654VFR', 'motor2', '2023-05-18 16:00:00'),
('3c4b5a6d-7890-4f21-b5a8-9c7d8e6f5a4b', '6789CVB', 'mec1', '2023-05-18 16:30:00'),
('2d1e3c4b-98a7-4d5f-b6c0-9e8f7a6d5c4b', '3456NJH', 'mec2', '2023-05-18 17:00:00'),
('1a2b3c4d-5e6f-4a3b-8c2d-1e3f4a5b6c7d', '2345KJH', 'int1', '2023-05-18 17:30:00'),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf2', '4567JKL', 'motor1', '2023-05-18 18:00:00'),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf3', '2345SDF', 'elec1', '2023-05-18 18:30:00'),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf4', '8765CVB', 'mec1', '2023-05-18 19:00:00'),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf5', '5432NHY', 'int1', '2023-05-18 19:30:00');

  

INSERT INTO informe (cita_id, informe_favorable, informe_frenado, informe_contaminacion, informe_interior, informe_luces)
VALUES
('d9b0472b-7b11-4cd8-9485-41cc97fd3cf1', TRUE, 7.85, 32.76, TRUE, TRUE),
('8eb6816c-7ce3-49dc-8557-25cc0c60009d', TRUE, 5.21, 43.12, TRUE, TRUE),
('b7c0d84e-e83e-4172-aded-6448281af27e', TRUE, 3.76, 27.43, TRUE, TRUE),
('e6026487-0aa8-4de6-8a21-14e437d32c65', TRUE, 9.45, 48.93, TRUE, TRUE),
('378532d5-d833-4dbc-8a24-8b75c1a19dbf', TRUE, 6.89, 35.27, TRUE, TRUE),
('a44346ac-6e2b-4379-8b4f-1b325074a14f', TRUE, 8.12, 29.81, TRUE, TRUE),
('4b5e7d76-c5ce-41cc-82ce-3701a5489a5f', TRUE, 4.79, 42.37, TRUE, TRUE),
('3d746ec5-e093-48a7-807d-c7022712cdf0', TRUE, 7.33, 25.94, TRUE, TRUE),
('03062027-a788-4853-aa7d-66145f15b4b9', TRUE, 6.01, 39.12, TRUE, TRUE),
('049e38ac-c99f-4648-98b1-8567f0ce106c', TRUE, 9.88, 22.55, TRUE, TRUE),
('24e637c5-fe7e-440a-be5a-8b475cbf9c94', TRUE, 5.76, 45.23, TRUE, TRUE),
('ff3a0f3e-de06-4b49-8af8-782d5d8a3ed7', FALSE, 7.99, 28.77, TRUE, FALSE),
('e12d31cc-6958-4cae-ab62-ae2ed2bb2d35', FALSE, 6.55, 31.68, FALSE, TRUE),
('1af4d82a-d0f2-4478-8b1f-460c5e542783', TRUE, 4.23, 37.42, TRUE, TRUE),
('2221617a-7827-4221-936a-3d566981433d', TRUE, 9.12, 23.87, TRUE, TRUE),
('65e502d5-5cb5-4dd1-9ce0-b4e32bba1d9d', TRUE, 6.67, 46.29, TRUE, TRUE),
('7763cf5c-3777-4c71-85f1-f53ee5269d43', TRUE, 8.43, 26.35, TRUE, TRUE),
('88753a02-9471-4610-9ebb-cfaf451acd78', TRUE, 5.99, 41.58, TRUE, TRUE),
('8116633d-5e03-4305-a35a-c731abd1f2d0', FALSE, 7.21, 30.14, TRUE, FALSE),
('11365d3b-9bf4-49a0-a6e9-da355b2f1fd4', TRUE, 3.45, 34.76, TRUE, TRUE),
('d9b0412c-7b11-4cd8-9485-41cc97fd3cf1', TRUE, 7.85, 32.76, TRUE, TRUE),
('9f1e85f3-9ae5-46ae-8a1d-01a4d6f7d906', TRUE, 5.42, 42.68, TRUE, TRUE),
('7e55cd0a-123d-4568-8907-89a4c67524f2', FALSE, 8.71, 79.24, TRUE, TRUE),
('aa85bc3f-7f4d-4962-89e6-3cd4596df8a7', TRUE, 6.29, 53.12, TRUE, TRUE),
('e5d9c84a-432a-4b47-a1a0-287e89370e72', FALSE, 9.63, 28.45, FALSE, TRUE),
('65aa987b-345d-4f2b-9a1c-50bd03fd8e9c', TRUE, 7.94, 48.76, TRUE, TRUE),
('2f468d30-5ae3-4384-9cd9-c7f376d3decd', TRUE, 5.76, 37.89, TRUE, TRUE),
('b4e59c23-fd5e-4f21-9d8a-9e07a4097c8f', FALSE, 18.22, 42.53, TRUE, TRUE),
('a9c3d456-87e5-42b1-98c1-34ed2507db29', TRUE, 7.15, 51.24, TRUE, TRUE),
('e8c9a1b0-6f23-4a1b-892e-0c34ed8d3a45', FALSE, 9.01, 38.76, FALSE, FALSE),
('e6d5c4b3-45f2-4d1a-a987-6701e23a4f5d', TRUE, 7.83, 47.92, TRUE, TRUE),
('d0c9b8a7-321d-4e87-9c65-4b5a3f2e1d0c', FALSE, 8.95, 35.67, FALSE, TRUE),
('45b6a798-e4d3-412f-b7c8-96e3f2d1c0b9', TRUE, 7.32, 52.34, TRUE, TRUE),
('3c4b5a6d-7890-4f21-b5a8-9c7d8e6f5a4b', TRUE, 6.78, 45.67, TRUE, TRUE),
('2d1e3c4b-98a7-4d5f-b6c0-9e8f7a6d5c4b', TRUE, 7.91, 46.78, TRUE, TRUE),
('1a2b3c4d-5e6f-4a3b-8c2d-1e3f4a5b6c7d', FALSE, 9.45, 59.87, TRUE, TRUE),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf2', TRUE, 7.15, 51.24, TRUE, TRUE),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf3', FALSE, 9.01, 38.76, FALSE, FALSE),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf4', TRUE, 7.83, 47.92, TRUE, TRUE),
('d9t0412b-7b11-4cd8-9485-41cc97fd3cf5', FALSE, 8.95, 35.67, FALSE, TRUE);

/* Crea un procedimiento que liste los inspectores/trabajadores de la estación que
recibe como parámetro (la que el propietario ha elegido en la hoja de citas). Hazlo de
forma que puedas leer uno a uno y que controles que no se ha llegado al final del
fichero*/
-- nos aseguramos que no existe antes de crearlo
/* este procedimiento lista a todos trabajadores de una estacion*/
DROP PROCEDURE IF exists ListarInspector;
DELIMITER $$
CREATE PROCEDURE ListarInspector(IN estacion_entrada VARCHAR(20))
BEGIN
 DECLARE id_estacion VARCHAR (36);
SELECT estacion_id INTO id_estacion FROM estacion WHERE estacion_nombre = estacion_entrada ;
SELECT * FROM trabajador where estacion_id = id_estacion HAVING trabajador_plus_direccion = TRUE ;
END $$
DELIMITER ;

/* Llama al procedimiento anterior si es necesario para saber si el inspector de la cita
pertenece a esa estación. De ser así puedes cargar los datos en la tabla
INSPECCIÓN */

-- Llamar al procedimiento ListarInspectoresPorEstacion pasando como parámetro la estación deseada
CALL ListarInspectoresPorEstacion('EST001');




/*Controla, mediante un disparador, si se actualiza alguna inspección guardando la
información previa y la información que se ha modifi */
-- como el trigger no puede lanzar consultas y no tengo tablas donde almacenar el mensaje creo un chorriProcedimiento al que llamar
DELIMITER $$
CREATE PROCEDURE check_actualizada()
BEGIN
    SELECT ('INFORMACION ACTUALIZADA');
END $$
DELIMITER ;

-- ahora creamos el trigger
DELIMITER $$
CREATE TRIGGER inspeccion_actualizada
AFTER UPDATE ON informe
FOR EACH ROW
BEGIN
    -- Verificar si se ha modificado alguna columna relevante
    IF NEW.informe_favorable != OLD.informe_favorable OR NEW.informe_frenado != OLD.informe_frenado OR NEW.informe_contaminacion != OLD.informe_contaminacion
    OR NEW.informe_interior != OLD.informe_interior OR NEW.informe_luces != OLD.informe_luces THEN
	call check_actualizada();
    END IF;
END$$
DELIMITER ;


/* Programa el borrado de las citas de manera bimestral*/

-- Crear el evento programado
CREATE EVENT BorrarCitasBimestralmente
ON SCHEDULE
    EVERY 2 MONTH -- Ejecutar cada 2 meses
    STARTS CURRENT_TIMESTAMP + INTERVAL 2 MONTH -- Comenzar en la fecha actual + 2 meses
DO
    DELETE FROM cita WHERE cita_fecha <= CURDATE();
    
/* EXTRA crear informe cuando se genere una cita y borrar informe si se borra cita */

-- crear informe si se crea cita 
DELIMITER $$
CREATE TRIGGER generar_informe
AFTER INSERT ON cita
FOR EACH ROW
BEGIN
-- Insertar un nuevo informe con valores predeterminados
INSERT INTO informe (cita_id, informe_favorable, informe_frenado, informe_contaminacion, informe_interior, informe_luces)
VALUES (NEW.cita_id, FALSE, 0.00, 0.00, FALSE, FALSE);
END$$
DELIMITER ;

-- borrar informe si se borra cita 
DELIMITER $$
CREATE TRIGGER borrar_informe
AFTER DELETE ON cita
FOR EACH ROW
BEGIN
    -- Eliminar el informe asociado a la cita eliminada
    DELETE FROM informe WHERE cita_id = OLD.cita_id;
END$$
DELIMITER ;
