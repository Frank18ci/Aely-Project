DROP DATABASE IF EXISTS aeroline_aerly;
create database aeroline_aerly;
use aeroline_aerly;

create table pais(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    icono varchar(100),
    codigo_telefono_pais varchar(100) unique,
    estado bit
);

create table idioma(
	id int auto_increment primary key,
    nombre varchar(100) unique,
	estado bit
);
create table rol(
	id int auto_increment primary key,
    nombre varchar(100) unique
);

create table user(
	id int auto_increment primary key,
    correo_electronico varchar(100) unique,
    password varchar(365) unique,
    nombres varchar(100),
    apellidos varchar(100),
    fechaNacimiento timestamp,
    fechaRegistro timestamp,
    estado bit,
	id_pais int references pais(id),
    id_idioma int references idioma(id),
    id_rol int references rol(id)
);

create table estado(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    id_pais int references pais(id)
);

create table aeropuerto(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    codigo_iata varchar(100) unique,
    ubicacion varchar(365),
    direccion varchar(365),
    id_estado int references estado(id),
    id_idioma int references idioma(id),
    estado bit
);
create table aerolinea(
	id int auto_increment primary key,
    nombre varchar(100) unique
);

create table modelo_avion(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    capacidad int,
    peso float(10,2)
);

create table avion(
	id int auto_increment primary key,
    id_modelo int references modelo_avion(id),
    id_aerolinea int references aerolinea(id)
);

create table estado_vuelo(
	id int auto_increment primary key,
	estado varchar(100) unique
);

create table vuelo(
	id int auto_increment primary key,
    codigo_vuelo varchar(50) unique,
    id_avion int references avion(id),
    id_aeropuerto_salida int references aeropuerto(id),
    fecha_salida timestamp,
    id_aeropuerto_llegada int references aeropuerto(id),
    fecha_llegada timestamp,
    duracion int,
    id_estado_vuelo int references estado_vuelo(id),
    estado bit
);

create table clase_asiento(
	id int auto_increment primary key,
    tipo varchar(100) unique
);

create table estado_asiento(
	id int auto_increment primary key,
	estado varchar(100) unique
);

create table asiento(
	id int auto_increment primary key,
    id_vuelo int references vuelo(id),
    numero_asiento varchar(50) unique,
    id_clase_asiento int references clase_asiento(id),
    id_estado_asiento int references estado_asiento(id)
);

create table estado_reserva(
	id int auto_increment primary key,
	estado varchar(100) unique
);

create table reserva(
	id int auto_increment primary key,
    id_user int references user(id),
    fecha_reserva timestamp,
    id_estado_reserva int references estado_reserva(id)
);

create table ticket(
	id int auto_increment primary key,
    id_reserva int references reserva(id),
    id_asiento int references asiento(id),
    codigo_ticket varchar(100) unique,
    fecha_emision timestamp
);

create table metodo_pago(
	id int auto_increment primary key,
	metodo varchar(100) unique
);

create table estado_pago(
	id int auto_increment primary key,
	estado varchar(100) unique
);

create table pago(
	id int auto_increment primary key,
    id_reserva int references reserva(id),
    monto float(10,2),
    moneda varchar(100),
    id_metodo_pago int references metodo_pago(id),
    fecha_pago timestamp,
    id_estado_pago int references estado_pago(id)
);


-- Insertando datos de prueba 

use aeroline_aerly;
-- pais
INSERT INTO pais (nombre, icono, codigo_telefono_pais, estado) VALUES
('México', 'mx.png', '+52', 1),
('Estados Unidos', 'us.png', '+1', 1),
('España', 'es.png', '+34', 1),
('Argentina', 'ar.png', '+54', 1),
('Brasil', 'br.png', '+55', 1),
('Francia', 'fr.png', '+33', 1),
('Alemania', 'de.png', '+49', 1),
('Italia', 'it.png', '+39', 1),
('Japón', 'jp.png', '+81', 1),
('Canadá', 'ca.png', '+1', 1),
('Perú', 'pe.png', '+51', 1),
('Colombia', 'co.png', '+57', 1)

-- idioma
INSERT INTO idioma (nombre, estado) VALUES
('Español', 1),
('Inglés', 1),
('Francés', 1),
('Alemán', 1),
('Italiano', 1),
('Portugués', 1),
('Japonés', 1);

-- rol
INSERT INTO rol (nombre) VALUES
('Administrador'),
('Cliente');

-- user
INSERT INTO user (correo_electronico, password, nombres, apellidos, fechaNacimiento, fechaRegistro, estado, id_pais, id_idioma, id_rol) VALUES
('juan.perez@gmail.com', 'pass123', 'Juan', 'Perez', '1990-05-10', NOW(), 1, 1, 1, 2),
('maria.gomez@gmail.com', 'pass456', 'Maria', 'Gomez', '1985-08-22', NOW(), 1, 2, 2, 2),
('admin@aerly.com', 'adminpass', 'Admin', 'Aerly', '1980-01-01', NOW(), 1, 1, 1, 1),
('lucas.fernandez@gmail.com', 'pass789', 'Lucas', 'Fernandez', '1992-11-30', NOW(), 1, 3, 1, 2),
('sofia.martinez@gmail.com', 'pass321', 'Sofia', 'Martinez', '1995-03-15', NOW(), 1, 4, 1, 2);

-- estado
INSERT INTO estado (nombre, id_pais) VALUES
('Jalisco', 1),
('California', 2),
('Madrid', 3),
('Buenos Aires', 4),
('São Paulo', 5),
('Île-de-France', 6),
('Baviera', 7),
('Lombardía', 8),
('Tokio', 9),
('Ontario', 10),
('Lima', 11),
('Bogotá', 12);

-- aeropuerto
INSERT INTO aeropuerto (nombre, codigo_iata, ubicacion, direccion, id_estado, id_idioma, estado) VALUES
('Aeropuerto Internacional de Guadalajara', 'GDL', 'Guadalajara', 'Av. Aeropuerto 1500', 1, 1, 1),
('Aeropuerto Internacional de Los Ángeles', 'LAX', 'Los Ángeles', '1 World Way', 2, 2, 1),
('Aeropuerto Adolfo Suárez Madrid-Barajas', 'MAD', 'Madrid', 'Av. de la Hispanidad', 3, 1, 1),
('Aeropuerto Internacional de Ezeiza', 'EZE', 'Buenos Aires', 'Autopista Tte. Gral. Ricchieri', 4, 1, 1),
('Aeropuerto Internacional de São Paulo', 'GRU', 'São Paulo', 'Rod. Hélio Smidt', 5, 6, 1),
('Aeropuerto Charles de Gaulle', 'CDG', 'París', '95700 Roissy-en-France', 6, 3, 1),
('Aeropuerto de Múnich', 'MUC', 'Múnich', 'Nordallee 25', 7, 4, 1),
('Aeropuerto de Milán-Malpensa', 'MXP', 'Milán', '21010 Ferno', 8, 5, 1),
('Aeropuerto Internacional de Tokio', 'HND', 'Tokio', 'Hanedakuko', 9, 7, 1),
('Aeropuerto Internacional de Toronto Pearson', 'YYZ', 'Toronto', '6301 Silver Dart Dr', 10, 2, 1),
('Aeropuerto Internacional Jorge Chávez', 'LIM', 'Lima', 'Av. Elmer Faucett', 11, 1, 1),
('Aeropuerto Internacional El Dorado', 'BOG', 'Bogotá', 'Av. El Dorado', 12, 1, 1);

-- aerolinea
INSERT INTO aerolinea (nombre) VALUES
('Aeroméxico'),
('Delta Airlines'),
('Iberia'),
('Aerolineas Argentinas'),
('LATAM'),
('Air France'),
('Lufthansa'),
('Alitalia'),
('Japan Airlines'),
('Air Canada');

-- modelo_avion
INSERT INTO modelo_avion (nombre, capacidad, peso) VALUES
('Boeing 737', 180, 41000.50),
('Airbus A320', 150, 42000.00),
('Boeing 777', 350, 70000.00),
('Airbus A380', 500, 120000.00),
('Embraer 190', 100, 28000.00);

-- avion
INSERT INTO avion (id_modelo, id_aerolinea) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10);

-- estado_vuelo
INSERT INTO estado_vuelo (estado) VALUES
('Programado'),
('En vuelo'),
('Aterrizado'),
('Cancelado'),
('Retrasado');

-- vuelo
INSERT INTO vuelo (codigo_vuelo, id_avion, id_aeropuerto_salida, fecha_salida, id_aeropuerto_llegada, fecha_llegada, duracion, id_estado_vuelo, estado) VALUES
('AMX100', 1, 1, '2024-06-10 08:00:00', 2, '2024-06-10 12:00:00', 240, 1, 1),
('DL200', 2, 2, '2024-06-11 09:00:00', 3, '2024-06-11 13:00:00', 240, 1, 1),
('IB300', 3, 3, '2024-06-12 10:00:00', 4, '2024-06-12 16:00:00', 360, 1, 1),
('AR400', 4, 4, '2024-06-13 11:00:00', 5, '2024-06-13 15:00:00', 240, 1, 1),
('LA500', 5, 5, '2024-06-14 12:00:00', 6, '2024-06-14 18:00:00', 360, 1, 1);

-- clase_asiento
INSERT INTO clase_asiento (tipo) VALUES
('Económica'),
('Premium Economy'),
('Business'),
('Primera Clase');

-- estado_asiento
INSERT INTO estado_asiento (estado) VALUES
('Disponible'),
('Reservado'),
('Ocupado'),
('Mantenimiento');

-- asiento
INSERT INTO asiento (id_vuelo, numero_asiento, id_clase_asiento, id_estado_asiento) VALUES
(1, '1A', 1, 1),
(1, '1B', 1, 1),
(1, '2A', 2, 1),
(2, '1A', 1, 1),
(2, '1B', 1, 2),
(3, '1A', 3, 1),
(3, '1B', 3, 1),
(4, '1A', 4, 1),
(4, '1B', 4, 1),
(5, '1A', 1, 1);

-- estado_reserva
INSERT INTO estado_reserva (estado) VALUES
('Pendiente'),
('Confirmada'),
('Cancelada'),
('Finalizada');

-- reserva
INSERT INTO reserva (id_user, fecha_reserva, id_estado_reserva) VALUES
(1, NOW(), 2),
(2, NOW(), 1),
(3, NOW(), 2),
(4, NOW(), 3),
(5, NOW(), 2);

-- ticket
INSERT INTO ticket (id_reserva, id_asiento, codigo_ticket, fecha_emision) VALUES
(1, 1, 'TCKT1001', NOW()),
(2, 2, 'TCKT1002', NOW()),
(3, 3, 'TCKT1003', NOW()),
(4, 4, 'TCKT1004', NOW()),
(5, 5, 'TCKT1005', NOW());

-- metodo_pago
INSERT INTO metodo_pago (metodo) VALUES
('Tarjeta de Crédito'),
('Tarjeta de Débito'),
('PayPal'),
('Transferencia Bancaria'),
('Efectivo');

-- estado_pago
INSERT INTO estado_pago (estado) VALUES
('Pendiente'),
('Pagado'),
('Rechazado'),
('Reembolsado');

-- pago
INSERT INTO pago (id_reserva, monto, moneda, id_metodo_pago, fecha_pago, id_estado_pago) VALUES
(1, 5000.00, 'MXN', 1, NOW(), 2),
(2, 4500.00, 'USD', 2, NOW(), 2),
(3, 6000.00, 'EUR', 3, NOW(), 1),
(4, 7000.00, 'ARS', 4, NOW(), 2),
(5, 8000.00, 'BRL', 5, NOW(), 2);