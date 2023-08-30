create database evaluacionu3y4;
use evaluacionu3y4;

drop table incidencias;
drop table users;

create table users(

id integer primary key not null auto_increment,
correo varchar (20) not null, 
contra varchar (20) not null,
rol varchar (20) not null
);

select * from users;

insert into users (correo, contra, rol) values ('admin@gmail.com', 'admin', 'ADMIN_ROLE'),
('alumno@gmail.com', 'hola', 'STUDENT_ROLE');


create table incidencias(

id integer primary key not null auto_increment,
titulo varchar (50) not null, 
descripcion varchar (150) not null, 
tipoDeIncidencia varchar (10) NOT NULL,
estado varchar (10) NOT NULL,
usuario_id integer not null,
FOREIGN KEY (usuario_id) REFERENCES users(id)
);

select * from incidencias;