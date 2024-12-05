CREATE DEFINER=`root`@`localhost` FUNCTION `saltEncryp`(intStr VARCHAR(255), salt VARCHAR(16), encryStr VARCHAR(255)) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
	DECLARE tempCode VARCHAR(255) DEFAULT "";
    DECLARE result BOOL DEFAULT false;
    SET tempCode = CONCAT(intStr, salt);
    SET tempCode = replaceEncryp(tempCode);
    SET result = STRCMP(encryStr, tempCode);
RETURN result;
END