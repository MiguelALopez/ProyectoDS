DROP TABLE IF EXISTS sede CASCADE;
CREATE TABLE sede
(
    sede_numero        VARCHAR(5),
    sede_nombre        VARCHAR(30),
    sede_gerente       VARCHAR(15),
    sede_presupuesto   VARCHAR(15),
    sede_cant_camiones INT,
    sede_direccion     VARCHAR(30),
    PRIMARY KEY (sede_numero)
);

DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario
(
    usuario_cedula              VARCHAR(15),
    usuario_passwd              VARCHAR(32) NOT NULL,
    usuario_nombre              VARCHAR(30) NOT NULL,
    usuario_rol                 VARCHAR(15) NOT NULL,
    usuario_estado              VARCHAR(10) NOT NULL,
    usuario_fecha_nacimiento    DATE,
    usuario_direccion           VARCHAR(60),
    usuario_telefono            VARCHAR(15),
    usuario_celular             VARCHAR(15),
    usuario_fecha_incorporacion DATE,
    usuario_salario             VARCHAR(15),
    usuario_cuenta              VARCHAR(30),
    usuario_sede_numero         VARCHAR(5),
    PRIMARY KEY (usuario_cedula),
    FOREIGN KEY (usuario_sede_numero) REFERENCES sede (sede_numero)
);

DROP TABLE IF EXISTS pqr CASCADE;
CREATE TABLE pqr
(
    pqr_numero    VARCHAR(5),
    pqr_cedula    VARCHAR(15) NOT NULL,
    pqr_nombre    VARCHAR(50),
    pqr_sede      VARCHAR(5)  NOT NULL,
    pqr_tipo      VARCHAR(10),
    pqr_contenido TEXT,
    PRIMARY KEY (pqr_numero),
    FOREIGN KEY (pqr_sede) REFERENCES sede (sede_numero)
);

INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_rol, usuario_estado)
VALUES ('123', '123456', 'Administrador', 'Admin', '1');