
DROP TABLE if exists usuario;

CREATE TABLE usuario
(
	usuario_cedula varchar(15),
	usuario_passwd varchar(32) NOT NULL,
	usuario_nombre varchar(30) NOT NULL,
	usuario_rol varchar(15) NOT NULL,
	usuario_estado varchar(10) NOT NULL,
	usuario_fecha_nacimiento date,
	usuario_direccion varchar(60),
	usuario_telefono varchar(15),
	usuario_celular varchar(15),
	usuario_fecha_incorporacion date,
	usuario_salario varchar(15),
	usuario_cuenta varchar(30),
        usuario_sede_numero varchar(5),
	PRIMARY KEY (usuario_cedula),
        FOREIGN KEY (usuario_sede_numero) REFERENCES sede(sede_numero)
);

INSERT INTO usuario(usuario_cedula, usuario_passwd, usuario_nombre, usuario_rol, usuario_estado) 
VALUES ('123','202cb962ac59075b964b07152d234b70','Administrador','Admin','1');

DROP TABLE if exists sede;

CREATE TABLE sede
(
	sede_numero varchar(5),
	sede_nombre varchar(30),
	sede_gerente varchar(15),
	sede_presupuesto varchar(15),
	sede_cant_camiones int,
	sede_direccion varchar(30),
	PRIMARY KEY (sede_numero)
);


CREATE TABLE pqr
{
    pqr_numero varchar(5),
    pqr_cedula varchar(15) NOT NULL,
    pqr_nombre varchar(50),
    pqr_sede varchar(5) NOT NULL,
    pqr_tipo varchar(10),
    pqr_contenido text,
    PRIMARY KEY (pqr_numero)
};