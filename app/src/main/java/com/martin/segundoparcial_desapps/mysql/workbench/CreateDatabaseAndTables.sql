DROP DATABASE IF EXISTS control_tickets;

CREATE DATABASE IF NOT EXISTS control_tickets;

USE control_tickets;

CREATE TABLE IF NOT EXISTS roles(
	id INT PRIMARY KEY AUTO_INCREMENT,
	rol VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nro_id INT UNIQUE NOT NULL,
    contraseña VARCHAR(100) NOT NULL,
    bloqueado BOOL NOT NULL DEFAULT 0,
    rol_id INT NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS tickets(
	id INT PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS fallas_y_marcas(
	id INT PRIMARY KEY AUTO_INCREMENT,
	num_fallas INT NOT NULL DEFAULT 0,
    num_marcas INT NOT NULL DEFAULT 0,
    usuario_id INT NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS estados_tickets(
	id INT PRIMARY KEY AUTO_INCREMENT,
	estado VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS asignaciones(
	id INT PRIMARY KEY AUTO_INCREMENT,
	ticket_id INT NOT NULL,
    usuario_id INT NOT NULL,
    estado_id INT NOT NULL,
	FOREIGN KEY (ticket_id) REFERENCES tickets(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (estado_id) REFERENCES estados_tickets(id)
);