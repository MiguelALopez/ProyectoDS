
DROP TABLE if exists usuarios;

CREATE TABLE usuarios(
	user_cedula varchar(15),
	user_passwd varchar(30) NOT NULL,
	user_nombre varchar(30) NOT NULL,
	user_rol varchar(15) NOT NULL,
	user_estado varchar(10) NOT NULL,
	user_fecha_nacimiento date,
	user_direccion varchar(60),
	user_telefono varchar(15),
	user_celular varchar(15),
	user_fecha_incorporacion date,
	user_salario varchar(15),
	user_sede_id varchar(5),
	user_cuenta varchar(30),
	PRIMARY KEY (user_id)
);

INSERT INTO usuarios(user_cedula,user_passwd,user_nombre,user_rol,user_estado) 
VALUES ('123','202cb962ac59075b964b07152d234b70','Administrador','Admin','1');

DROP TABLE if exists sedes;

CREATE TABLE sedes(
	sede_id varchar(5),
	sede_nombre varchar(30),
	sede_gerente varchar(15),
	sede_presupuesto varchar(15),
	sede_cant_camiones int,
	sede_direccion varchar(30),
	PRIMARY KEY (sede_id)
);