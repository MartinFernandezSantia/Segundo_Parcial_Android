USE control_tickets;

DELIMITER $$
CREATE TRIGGER id_como_contraseña
BEFORE INSERT ON usuarios
FOR EACH ROW
BEGIN
	SET NEW.contraseña = NEW.id;
END$$
DELIMITER ;