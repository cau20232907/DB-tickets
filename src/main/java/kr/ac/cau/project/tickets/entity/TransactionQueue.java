package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 결제 정보 제외 다른 정보 임시 저장(일단 결제를 빼는 방향으로 설계함)
 * 사이트가 몰릴 수 있으니 일단 여기에 저장 후 순차적으로 처리함(프로시저 사용)
 * 임시 Table이므로 일단 다 때려박는 방식임
 * 여기서 확정되면 이제 결제를 진행할 수 있음
 * 결제는 구매에 성공했는지 확인 후 진행
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionQueue {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private ConcertDate concertDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private SeatGrade seatGrade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;
    private LocalDateTime requestTime; //요청한 시간, 이게 ticket의 시간이 됨
    //private Boolean isOnline;

    public List<TransactionQueue> copyBySeat(List<Seat> seats) {
        return seats.stream().map(seat1 ->
            TransactionQueue.builder()
                    .time(getTime())
                    .member(getMember())
                    .concertDate(getConcertDate())
                    .seatGrade(getSeatGrade())
                    .seat(seat1).build()
        ).collect(Collectors.toList());
    }
}