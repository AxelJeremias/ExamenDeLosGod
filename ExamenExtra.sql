create database evaluacionu3y4;
use evaluacionu3y4;

drop table incidencias;
drop table users;

create table users(
id integer primary key not null auto_increment,
nombre varchar (20) not null, 
apellidoP varchar (20) not null,
apellidoM varchar (20) not null,
correo varchar (20) not null, 
contra varchar (20) not null,
curp varchar (18) not null,
fecha date not null,
estado varchar (20) not null,
rol varchar (20) not null
);

select * from users;

insert into users (nombre, apellidoP, apellidoM, correo, contra, curp, fecha, estado, rol) values
('benjamin', 'si', 'so','alumno@gmail.com', 'hola', 'XA5', '2004-09-22', 'ACTIVO', 'USER_ROLE');

insert into users (nombre, apellidoP, apellidoM, correo, contra, curp, fecha, estado, rol) values
('SR_ADMIN', 'na', 'na', 'admin@gmail.com', 'admingod', 'XA5', '2003-08-07', 'ACTIVO', 'ADMIN_ROLE');

insert into users (nombre, apellidoP, apellidoM, correo, contra, curp, fecha, estado, rol) values
('pepe', 'na', 'na', 'pepe@gmail.com', 'pepe', 'XA6', '2003-08-07', 'ACTIVO', 'INSTRUCTORE_ROLE');


drop table clases; 

create table clases (
id integer primary key not null auto_increment,
nombre varchar (50) not null, 
descripcion varchar (50) not null,
estado varchar (50) not null,
instructor integer not null, 
foreign key(instructor) references users (id)
);

create table temarios (
id integer primary key not null auto_increment,
descripcion varchar (50) not null,
clase integer not null, 
foreign key(clase) references clases (id)
);