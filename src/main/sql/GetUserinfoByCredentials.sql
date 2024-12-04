CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserinfoByCredentials`(
    IN input_username VARCHAR(255),
    IN input_password VARCHAR(255)
)
BEGIN
    -- 선언된 변수
    DECLARE found_salt VARCHAR(255);
    DECLARE found_hash VARCHAR(255);
    DECLARE user_id BIGINT;

    -- 비밀번호와 연관된 정보를 가져옵니다.
    SELECT c.salt, c.hash_value, u.id
    INTO found_salt, found_hash, user_id
    FROM credential c
    INNER JOIN userinfo u ON c.userinfo_id = u.id
    WHERE u.username = input_username;

    -- 비밀번호 비교
    IF found_hash IS NOT NULL AND found_salt IS NOT NULL THEN
        IF saltEncryp(input_password, found_salt, found_hash) = 0 THEN
            -- 일치하는 경우 사용자 정보를 반환
            SELECT u.id 
            FROM userinfo u 
            WHERE u.id = user_id;
        ELSE
            -- 일치하지 않는 경우 빈 결과를 반환
            SELECT NULL AS id LIMIT 0;
        END IF;
    ELSE
        -- 사용자가 없거나 비밀번호가 누락된 경우 빈 결과 반환
        SELECT NULL AS id LIMIT 0;
    END IF;
END