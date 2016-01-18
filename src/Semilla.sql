/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: semilla.sql
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

DROP TABLE IF EXISTS sede CASCADE;
CREATE TABLE sede
(
    sede_numero        VARCHAR(5),
    sede_nombre        VARCHAR(90),
    sede_gerente       VARCHAR(30),
    sede_presupuesto   VARCHAR(30),
    sede_cant_camiones INT,
    sede_direccion     VARCHAR(90),
    PRIMARY KEY (sede_numero)
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
    usuario_cedula              VARCHAR(30),
    usuario_passwd              VARCHAR(90) NOT NULL,
    usuario_nombre              VARCHAR(90) NOT NULL,
    usuario_rol                 VARCHAR(60) NOT NULL,
    usuario_estado              VARCHAR(30) NOT NULL,
    usuario_fecha_nacimiento    VARCHAR(25),
    usuario_direccion           VARCHAR(90),
    usuario_telefono            VARCHAR(30),
    usuario_celular             VARCHAR(30),
    usuario_fecha_incorporacion VARCHAR(25),
    usuario_salario             VARCHAR(30),
    usuario_cuenta              VARCHAR(30),
    usuario_sede_numero         VARCHAR(5),
    PRIMARY KEY (usuario_cedula),
    FOREIGN KEY (usuario_sede_numero) REFERENCES sede (sede_numero)
);

DROP TABLE IF EXISTS pqr CASCADE;
CREATE TABLE pqr
(
    pqr_numero    VARCHAR(5),
    pqr_cedula    VARCHAR(30) NOT NULL,
    pqr_nombre    VARCHAR(90) NOT NULL,
    pqr_sede      VARCHAR(5)  NOT NULL,
    pqr_tipo      VARCHAR(30) NOT NULL,
    pqr_contenido TEXT        NOT NULL,
    pqr_estado    VARCHAR(30) NOT NULL,
    PRIMARY KEY (pqr_numero),
    FOREIGN KEY (pqr_sede) REFERENCES sede (sede_numero)
);

DROP TABLE IF EXISTS pos CASCADE;
CREATE TABLE pos
(
    pos_id        VARCHAR(5),
    pos_nombre    VARCHAR(60) NOT NULL,
    pos_direccion VARCHAR(90) NOT NULL,
    PRIMARY KEY (pos_numero)
);

DROP SEQUENCE IF EXISTS venta_seq CASCADE;
CREATE SEQUENCE venta_seq
    START WITH 100000;

DROP TABLE IF EXISTS venta CASCADE;
CREATE TABLE venta
(
    venta_id        VARCHAR DEFAULT nextval('venta_seq'::regclass) NOT NULL,
    venta_cedula    VARCHAR(60) NOT NULL,
    venta_nombre    VARCHAR(90) NOT NULL,
    venta_direccion VARCHAR(90) NOT NULL,
    venta_fecha     DATE        NOT NULL,
    venta_total     DECIMAL     NOT NULL,
    pos_id          VARCHAR(30) NOT NULL,
    PRIMARY KEY (pos_numero),
    FOREIGN KEY (pos_id) REFERENCES pos (pos_id)
);

DROP TABLE IF EXISTS paquete CASCADE;
CREATE TABLE paquete
(
    venta_id            VARCHAR NOT NULL,
    paquete_numero      INTEGER NOT NULL,
    paquete_volumen     DECIMAL NOT NULL,
    paquete_peso        DECIMAL NOT NULL,
    paquete_descripcion TEXT    NOT NULL,
    PRIMARY KEY (venta_id, paquete_numero),
    FOREIGN KEY (venta_id) REFERENCES venta (venta_id)
);

INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_rol, usuario_estado)
VALUES ('123', '123456', 'Miguel', 'Administrador', 'Activo');

INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_rol, usuario_estado)
VALUES ('456', 'holi', 'Andres', 'Secretaria', 'Activo');

INSERT INTO sede(sede_numero, sede_nombre, sede_direccion)
    VALUES ('001', 'Melendez', 'Carrera 100');

INSERT INTO pqr (pqr_numero, pqr_cedula, pqr_nombre, pqr_sede, pqr_tipo, pqr_contenido, pqr_estado)
    VALUES ('1', '123', 'Miguel', '001', 'Peticion', 'nada', 'Nuevo')
