package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 미결제 티켓
 * 결제정보, 결제시간이 없다
 * 이 자체로 사용할 수 없고, FreeSeatTicket이나 ReservedSeatTicket으로 사용해야 함
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public abstract class NonpaidTicket {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private ConcertDate concertDate;
    private Boolean isOnline;
//    @ManyToOne(fetch = FetchType.LAZY) //여러 티켓이 한 번에 배송될 수 있음
//    private Delivery delivery;
    private LocalDateTime purchaseTime;

    public abstract SeatGrade getSeatGrade();
}
