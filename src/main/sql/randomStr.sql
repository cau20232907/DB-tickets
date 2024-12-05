CREATE DEFINER=`root`@`localhost` FUNCTION `randomStr`() RETURNS varchar(16) CHARSET utf8mb4
    NO SQL
BEGIN
	DECLARE seed VARCHAR(32) DEFAULT "NWandfjIARUETARHFADFBDFJAEKEAREG";
	DECLARE str VARCHAR(16) DEFAULT "";
    DECLARE num INT DEFAULT 0;
    DECLARE i INT default 0;
    WHILE i < 16 DO
		SET num = FLOOR(RAND() * 32 + 1);
        SET str = CONCAT(str, SUBSTR(seed, num, 1));
        SET i = i + 1;
	END WHILE;
RETURN str;
END