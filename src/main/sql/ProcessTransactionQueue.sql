CREATE DEFINER=`root`@`localhost` PROCEDURE `ProcessTransactionQueue`()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_id BIGINT;
    DECLARE v_concert_date_id BIGINT;
    DECLARE v_member_id BIGINT;
    DECLARE v_seat_id BIGINT;
    DECLARE v_seat_grade_id BIGINT;
    DECLARE v_time DATETIME(6);
    DECLARE is_reserved_duplicate INT DEFAULT 0;
    DECLARE free_seat_count INT DEFAULT 0;
    DECLARE free_seat_limit_value INT DEFAULT 0;
    DECLARE process_result TINYINT(1);

    -- 커서 선언
    DECLARE cur CURSOR FOR
    SELECT id, concert_date_id, member_id, seat_id, seat_grade_id, time
    FROM transaction_queue
    ORDER BY time ASC LIMIT 1;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;

    -- 반복 처리
    FETCH cur INTO v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time;

    WHILE done = 0 DO
        -- 트랜잭션 시작
        START TRANSACTION;

        -- **reserved_seat 중복 확인**: 동일한 concert_date_id와 seat_id가 존재하는지
        IF v_seat_id IS NOT NULL THEN
            SET is_reserved_duplicate = (
                SELECT EXISTS (
                    SELECT 1
                    FROM (
                        SELECT n.concert_date_id as concert_date_id, rn.seat_id as seat_id
                        FROM reserved_seat_nonpaid_ticket as rn inner join nonpaid_ticket as n on rn.id = n.id
                        UNION ALL
                        SELECT t.concert_date_id as concert_date_id, r.seat_id as seat_id
                        FROM reserved_seat_ticket as r inner join ticket as t on r.id = t.id
                    ) AS all_reserved
                    WHERE concert_date_id = v_concert_date_id AND seat_id = v_seat_id
                )
            );

            -- 중복이면 데이터 삭제만
            IF is_reserved_duplicate = 1 THEN
                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=0;
            ELSE
                -- 데이터 이동
                INSERT INTO nonpaid_ticket (id, is_online, purchase_time, concert_date_id, member_id)
                VALUES (v_id, b'1', v_time, v_concert_date_id, v_member_id);

                INSERT INTO reserved_seat_nonpaid_ticket (id, seat_id)
                VALUES (v_id, v_seat_id);

                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=1;
            END IF;

        ELSEIF v_seat_grade_id IS NOT NULL THEN
            -- **free_seat 중복 확인 및 제한 조회**
            SET free_seat_count = (
                SELECT COUNT(*)
                FROM (
                    SELECT n.concert_date_id as concert_date_id, fn.seat_id as seat_grade_id
                    FROM free_seat_nonpaid_ticket as fn inner join nonpaid_ticket as n on fn.id = n.id
                    UNION ALL
                    SELECT t.concert_date_id as concert_date_id, f.seat_id as seat_grade_id
                    FROM free_seat_ticket as f inner join ticket as t on f.id = t.id
                ) AS all_free
                WHERE concert_date_id = v_concert_date_id AND seat_grade_id = v_seat_grade_id
            );

            SET free_seat_limit_value = (
                SELECT value
                FROM free_seat_limit
                WHERE seat_grade_id = v_seat_grade_id
            );

            -- 제한 초과 여부 판단
            IF free_seat_count >= free_seat_limit_value THEN
                -- 제한 초과: 데이터 삭제만
                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=0;
            ELSE
                -- 제한 미달: 데이터 이동
                INSERT INTO nonpaid_ticket (id, is_online, purchase_time, concert_date_id, member_id)
                VALUES (v_id, b'1', v_time, v_concert_date_id, v_member_id);

                INSERT INTO free_seat_nonpaid_ticket (id, seat_id)
                VALUES (v_id, v_seat_grade_id);

                DELETE FROM transaction_queue WHERE id = v_id;
                SET process_result=1;
            END IF;
        END IF;

		-- 이력 기록
		INSERT INTO transaction_queue_record (
			id, concert_date_id, member_id, seat_id, seat_grade_id, time, if_succeed
		) VALUES (
			v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time, process_result
		);

        -- 트랜잭션 커밋
        COMMIT;
        
        CLOSE cur;
        OPEN cur;

        -- 다음 데이터 처리
        FETCH cur INTO v_id, v_concert_date_id, v_member_id, v_seat_id, v_seat_grade_id, v_time;
    END WHILE;

    CLOSE cur;
END