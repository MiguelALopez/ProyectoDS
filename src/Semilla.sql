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
    sede_nombre        VARCHAR(90)  NOT NULL,
    sede_direccion     VARCHAR(90)  NOT NULL,
    sede_ciudad        VARCHAR(90)  NOT NULL,
    sede_gerente       VARCHAR(30),
    sede_cant_camiones INTEGER,    
    PRIMARY KEY (sede_numero)
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
    usuario_cedula              VARCHAR(30),
    usuario_passwd              VARCHAR(90) NOT NULL,
    usuario_nombre              VARCHAR(90) NOT NULL,
    usuario_apellido            VARCHAR(90) NOT NULL,
    usuario_rol                 VARCHAR(60) NOT NULL,
    usuario_estado              VARCHAR(30) NOT NULL,
    usuario_fecha_nacimiento    VARCHAR(25),
    usuario_direccion           VARCHAR(90),
    usuario_telefono            VARCHAR(30),    
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
    PRIMARY KEY (pos_id)
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
    venta_metodo    VARCHAR(30) NOT NULL,
    venta_seguro    DECIMAL     NOT NULL,
    venta_subtotal  DECIMAL     NOT NULL,
    venta_iva       DECIMAL     NOT NULL,
    venta_total     DECIMAL     NOT NULL,
    pos_id          VARCHAR(30) NOT NULL,
    PRIMARY KEY (venta_id),
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
    paquete_costo       DECIMAL NOT NULL,
    PRIMARY KEY (venta_id, paquete_numero),
    FOREIGN KEY (venta_id) REFERENCES venta (venta_id)
);

ALTER TABLE sede
ADD CONSTRAINT sede_gerente_fkey FOREIGN KEY (sede_gerente) REFERENCES usuario (usuario_cedula);

INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('123', '123456', 'Miguel', 'Lopez', 'Administrador', 'Activo');

INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('456', 'holi', 'Andres', 'Martinez', 'Secretaria', 'Activo');

INSERT INTO sede(sede_numero, sede_nombre, sede_direccion, sede_ciudad)
    VALUES ('001', 'Melendez', 'Carrera 100', 'Cali');

INSERT INTO pqr (pqr_numero, pqr_cedula, pqr_nombre, pqr_sede, pqr_tipo, pqr_contenido, pqr_estado)
    VALUES ('1', '123', 'Miguel', '001', 'Peticion', 'nada', 'Nuevo');

INSERT INTO pos (pos_id, pos_nombre, pos_direccion)
VALUES ('1', 'La 50', 'Calle 50');

INSERT INTO venta (venta_cedula, venta_nombre, venta_direccion, venta_fecha, venta_metodo, venta_seguro, venta_subtotal, venta_iva, venta_total, pos_id)
VALUES ('1144082592', 'Camilo Ruiz', 'Calle 1', '2016-01-18', 'Efectivo', 500, 900000, 100000, 1000000, '1');

INSERT INTO paquete (venta_id, paquete_numero, paquete_volumen, paquete_peso, paquete_descripcion, paquete_costo)
VALUES ('100000', 1, 100, 1000, 'Ampeta', 5000);

INSERT INTO venta (venta_cedula, venta_nombre, venta_direccion, venta_fecha, venta_metodo, venta_seguro, venta_subtotal, venta_iva, venta_total, pos_id)
VALUES ('1144082592', 'Camilo Ruiz', 'Calle 1', '2016-01-18', 'Efectivo', 400, 900000, 100000, 2000000, '1');

INSERT INTO paquete (venta_id, paquete_numero, paquete_volumen, paquete_peso, paquete_descripcion, paquete_costo)
VALUES ('100001', 1, 100, 1000, 'Ampeta', 9000);
