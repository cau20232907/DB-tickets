CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertUserWithCredentials`(
    IN input_username VARCHAR(255),
    IN input_password VARCHAR(255)
)
BEGIN
    -- 선언된 변수
    DECLARE generated_salt VARCHAR(255);
    DECLARE encrypted_password VARCHAR(255);
    DECLARE new_user_id BIGINT;
    
    start transaction;

    -- 1. 무작위 salt 생성
    SET generated_salt = randomStr();

    -- 2. 비밀번호에 salt 추가 및 암호화
    SET encrypted_password = replaceEncryp(CONCAT(input_password, generated_salt));

    -- 3. userinfo 테이블에 username 삽입
    INSERT INTO userinfo (username)
    VALUES (input_username);

    -- 4. 방금 삽입한 사용자의 ID 가져오기
    SET new_user_id = LAST_INSERT_ID();

    -- 5. credential 테이블에 암호화된 비밀번호와 salt 삽입
    INSERT INTO credential (userinfo_id, hash_value, salt)
    VALUES (new_user_id, encrypted_password, generated_salt);
    
    -- 6. Member 테이블에 데이터 삽입
    INSERT INTO Member (id)
    VALUES (new_user_id);
    
    commit;
END