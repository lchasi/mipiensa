create table usuario(
usuid SERIAL,
usunombre varchar (100),
usuapellido varchar (100)
);
insert into usuario (usunombre,usuapellido) values ('Marco','Guaman');

create table preferencia(
id SERIAL,
descripcion varchar (100)
);
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