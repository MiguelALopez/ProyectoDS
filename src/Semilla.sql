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
    sede_numero        VARCHAR  NOT NULL,
    sede_nombre        VARCHAR  NOT NULL,
    sede_direccion     VARCHAR  NOT NULL,
    sede_ciudad        VARCHAR  NOT NULL,
    sede_gerente       VARCHAR,
    sede_cant_camiones INTEGER,    
    PRIMARY KEY (sede_numero)
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
    usuario_cedula              VARCHAR NOT NULL,
    usuario_passwd              VARCHAR NOT NULL,
    usuario_nombre              VARCHAR NOT NULL,
    usuario_apellido            VARCHAR NOT NULL,
    usuario_rol                 VARCHAR NOT NULL,
    usuario_estado              VARCHAR NOT NULL,
    usuario_fecha_nacimiento    VARCHAR,
    usuario_direccion           VARCHAR,
    usuario_telefono            VARCHAR,    
    usuario_fecha_incorporacion VARCHAR,
    usuario_salario             VARCHAR,
    usuario_cuenta              VARCHAR,
    usuario_sede_numero         VARCHAR,
    PRIMARY KEY (usuario_cedula),
    FOREIGN KEY (usuario_sede_numero) REFERENCES sede (sede_numero)
);

DROP SEQUENCE IF EXISTS pqr_seq CASCADE;
CREATE SEQUENCE pqr_seq
    START WITH 100000;

DROP TABLE IF EXISTS pqr CASCADE;
CREATE TABLE pqr
(
    pqr_numero      VARCHAR DEFAULT nextval('pqr_seq'::regclass) NOT NULL,
    pqr_fecha       DATE    NOT NULL,  
    pqr_tipo        VARCHAR NOT NULL,
    pqr_contenido   TEXT    NOT NULL,
    pqr_estado      VARCHAR NOT NULL,
    pqr_cedula      VARCHAR NOT NULL,
    pqr_nombre      VARCHAR NOT NULL,
    pqr_sede        VARCHAR NOT NULL,
    PRIMARY KEY (pqr_numero),
    FOREIGN KEY (pqr_sede) REFERENCES sede (sede_numero)
);

DROP TABLE IF EXISTS pos CASCADE;
CREATE TABLE pos
(
    pos_id        VARCHAR NOT NULL,
    pos_nombre    VARCHAR NOT NULL,
    pos_direccion VARCHAR NOT NULL,
    PRIMARY KEY (pos_id)
);

DROP SEQUENCE IF EXISTS venta_seq CASCADE;
CREATE SEQUENCE venta_seq
    START WITH 100000;

DROP TABLE IF EXISTS venta CASCADE;
CREATE TABLE venta
(
    venta_id        VARCHAR DEFAULT nextval('venta_seq'::regclass) NOT NULL,
    venta_cedula    VARCHAR NOT NULL,
    venta_nombre    VARCHAR NOT NULL,
    venta_direccion VARCHAR NOT NULL,
    venta_fecha     DATE    NOT NULL,
    venta_metodo    VARCHAR NOT NULL,
    venta_seguro    DECIMAL NOT NULL,
    venta_subtotal  DECIMAL NOT NULL,
    venta_iva       DECIMAL NOT NULL,
    venta_total     DECIMAL NOT NULL,
    pos_id          VARCHAR NOT NULL,
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
VALUES ('123', '123', 'Miguel', 'Lopez', 'Administrador', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('345', '345', 'Camilo', 'Ruiz', 'Administrador', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('567', '567', 'Andres', 'Martinez', 'Administrador', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('789', '789', 'Cristian', 'Jurado', 'Administrador', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('1', '1', 'Talitha', 'Ribble', 'Gerente', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('2', '2', 'Ginette', 'Justiniano', 'Gerente', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('3', '4', 'Petrina', 'Najar', 'Gerente', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('5', '5', 'Ailene', 'Sommers', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('6', '6', 'Darrel', 'Shanks', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('7', '7', 'Tandra', 'Buxton', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('8', '8', 'Sarah', 'Davidson', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('9', '9', 'Genevieve', 'Mclellan', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('10', '10', 'Robena', 'Barreta', 'Secretaria', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('11', '11', 'Janetta', 'Markee', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('12', '12', 'Dario', 'Banker', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('13', '13', 'Roseann', 'Marc', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('14', '14', 'Barry', 'Mcculler', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('15', '15', 'Latonia', 'Newport', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('16', '16', 'Phil', 'Hoefer', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('17', '17', 'Lamonica', 'Damon', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('18', '18', 'Zandra', 'Tinch', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('19', '19', 'Christia', 'Windley', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('20', '20', 'Toshiko', 'Wagoner', 'Auxiliar de Operacion', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('21', '21', 'Eloy', 'Sager', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('22', '22', 'Mack', 'Lloyd', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('23', '23', 'Florene', 'Lummus', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('24', '24', 'Pamela', 'Conlin', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('25', '25', 'Benjamin', 'Bustillos', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('26', '26', 'Colin', 'Loving', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('27', '27', 'Santos', 'Silvester', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('28', '28', 'Marchall', 'Kabel', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('29', '29', 'Selina', 'Haris', 'Operador de Oficina', 'Activo');
INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado)
VALUES ('30', '30', 'Miranda', 'Gray', 'Operador de Oficina', 'Activo');

INSERT INTO sede(sede_numero, sede_nombre, sede_direccion, sede_ciudad, sede_gerente)
VALUES ('001', 'Sur', 'Carrera 100', 'Cali', '1');
INSERT INTO sede(sede_numero, sede_nombre, sede_direccion, sede_ciudad, sede_gerente)
VALUES ('002', 'Norte', 'Avenida 4N', 'Cali', '2');
INSERT INTO sede(sede_numero, sede_nombre, sede_direccion, sede_ciudad, sede_gerente)
VALUES ('003', 'Centro', 'Calle 34', 'Cali', '3');

INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-10', 'Peticion', 'nada', 'Nuevo', '1144', 'Mauricio', '001');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-11', 'Peticion', 'nada', 'Nuevo', '1155', 'Roy', '002');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-12', 'Peticion', 'nada', 'Nuevo', '1166', 'Jeff', '003');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-13', 'Peticion', 'nada', 'Nuevo', '1177', 'Kevin', '001');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-14', 'Queja', 'nada', 'Nuevo', '1144', 'Gustavo', '002');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-15', 'Queja', 'nada', 'Nuevo', '1155', 'Jesus', '003');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-16', 'Queja', 'nada', 'Nuevo', '1188', 'Miguel', '001');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-17', 'Reclamo', 'nada', 'Nuevo', '1199', 'Fernando', '002');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-18', 'Reclamo', 'nada', 'Nuevo', '1111', 'Andres', '003');
INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)
VALUES ('2016-01-19', 'Reclamo', 'nada', 'Nuevo', '1122', 'Cristian', '001');

INSERT INTO pos (pos_id, pos_nombre, pos_direccion)
VALUES ('1', 'La 50', 'Calle 50');
INSERT INTO pos (pos_id, pos_nombre, pos_direccion)
VALUES ('2', 'La 60', 'Calle 60');
INSERT INTO pos (pos_id, pos_nombre, pos_direccion)
VALUES ('3', 'La 70', 'Calle 70');

INSERT INTO venta (venta_cedula, venta_nombre, venta_direccion, venta_fecha, venta_metodo, venta_seguro, venta_subtotal, venta_iva, venta_total, pos_id)
VALUES ('1144082592', 'Camilo Ruiz', 'Calle 1', '2016-01-18', 'Efectivo', 500, 900000, 100000, 1000000, '1');
INSERT INTO paquete (venta_id, paquete_numero, paquete_volumen, paquete_peso, paquete_descripcion, paquete_costo)
VALUES ('100000', 1, 100, 1000, 'Ampeta', 5000);

INSERT INTO venta (venta_cedula, venta_nombre, venta_direccion, venta_fecha, venta_metodo, venta_seguro, venta_subtotal, venta_iva, venta_total, pos_id)
VALUES ('1144082592', 'Camilo Ruiz', 'Calle 1', '2016-01-18', 'Efectivo', 400, 900000, 100000, 2000000, '1');
INSERT INTO paquete (venta_id, paquete_numero, paquete_volumen, paquete_peso, paquete_descripcion, paquete_costo)
VALUES ('100001', 1, 100, 1000, 'Ampeta', 9000);
