package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

/**
 * 결제 정보 제외 다른 정보 임시 저장(일단 결제를 빼는 방향으로 설계함)
 * 사이트가 몰릴 수 있으니 일단 여기에 저장 후 순차적으로 처리함(프로시저 사용)
 * 임시 Table이므로 일단 다 때려박는 방식임
 * 여기서 확정되면 이제 결제를 진행할 수 있음
 * 결제는 구매에 성공했는지 확인 후 진행
 */
@Entity
public class TransactionQueue {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime time;
    @ManyToOne
    private Member member;
    @ManyToOne
    private ConcertDate concertDate;
    @ManyToOne
    private SeatGrade seatGrade;
    @ManyToOne
    private Seat seat;
    private Boolean isOnline;
}