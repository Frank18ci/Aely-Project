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

create table user(
	id int auto_increment primary key,
    correo_electronico varchar(100) unique,
    password varchar(100) unique,
    nombres varchar(100),
    apellidos varchar(100),
    fechaNacimiento timestamp,
    fechaRegistro timestamp,
    estado bit,
	id_pais int references pais(id),
    id_idioma int references idioma(id)
);

create table estado(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    id_pais int references pais(id)
);


create table aeropuerto(
	id int auto_increment primary key,
    nombre varchar(100) unique,
    ubicacion varchar(365),
    direccion varchar(365),
    id_estado int references estado(id),
    id_idioma int references idioma(id),
    estado bit
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

create table vuelo(
	id int auto_increment primary key,
    id_aeropuerto_salida int references aeropuerto(id),
    fecha_salida timestamp,
    id_aeropuerto_llegada int references aeropuerto(id),
    fecha_llegada timestamp,
    capacidad int,
    estado bit
);

create table vuelo_user(
	id int auto_increment primary key,
    id_vuelo int references vuelo(id),
    id_tipo_persona int references tipo_persona(id),
    estado bit
);




