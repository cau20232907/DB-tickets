CREATE DEFINER=`root`@`localhost` FUNCTION `replaceEncryp`(input VARCHAR(255)) RETURNS varchar(255) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
    DECLARE transCode VARCHAR(255) DEFAULT input; 
    DECLARE firstChar CHAR(1) DEFAULT 'a';  
    DECLARE secondChar CHAR(1) DEFAULT 'b'; 

    RETURN REPLACE(transCode, firstChar, secondChar);
END