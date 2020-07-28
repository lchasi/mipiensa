drop table usuario;

create table usuario(
usuid SERIAL,
usunombre varchar (100),
usuapellido varchar (100),
nombreusuario varchar (100),
contrasena varchar (100)
);

insert into usuario (usunombre,usuapellido,nombreUsuario, contrasena) values ('Marco','Guaman','marco','123');
insert into usuario (usunombre,usuapellido,nombreUsuario, contrasena) values ('Marco1','Guama1n','marco1','1231');

create table preferencia(
id SERIAL,
descripcion varchar (100)
);

drop table pregunta;
create table pregunta(
numero SERIAL,
pregunta varchar (100),
ruta varchar (100),
respuesta int
);
insert into pregunta (pregunta,ruta,respuesta) values ('Las estaciones del año','c:/imgs/ui.png',1);
insert into pregunta (pregunta,ruta,respuesta) values ('Las mese del año','c:/imgs/ui.png',1);
insert into pregunta (pregunta,ruta,respuesta) values ('Las semanas del año','c:/imgs/ui.png',1);
insert into pregunta (pregunta,ruta,respuesta) values ('Las dias del año','c:/imgs/ui.png',1);


insert into preferencia (descripcion) values ('Voley');
insert into preferencia (descripcion) values ('Tenis');
insert into preferencia (descripcion) values ('Baketball');

select * from usuario;
