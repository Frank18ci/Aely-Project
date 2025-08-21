DROP DATABASE IF EXISTS aeroline_aerly;
create database aeroline_aerly;
use aeroline_aerly;

create table pais(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    icono varchar(100),
    codigoTelefonoPais varchar(100) unique,
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

create table clase_vuelo(
	id int auto_increment primary key,
    nombre varchar(100) unique,
	estado bit
);
create table tipo_persona(
	id int auto_increment primary key,
    tipo varchar(100) unique,
	estado bit
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
