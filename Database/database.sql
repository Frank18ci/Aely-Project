create database aeroline_aerly;
use aeroline_aerly;

create table user(
	id int auto_increment primary key,
    correo_electronico varchar(100) unique,
    password varchar(100) unique,
    nombres varchar(100),
    apellidos varchar(100),
    fechaNacimiento timestamp,
    
);

create table pais(
	id int auto_increment primary key,
);