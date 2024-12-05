package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 티켓 기록, 결제기록에 연결
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public abstract class TicketRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private PaymentRecord payment;
    @ManyToOne(fetch = FetchType.LAZY)
    private ConcertDate concertDate;
    private LocalDateTime purchaseTime;
    private Boolean isOnline;
    @ManyToOne(fetch = FetchType.LAZY) //여러 티켓이 한 번에 배송될 수 있음
    private DeliveryRecord delivery;

    public abstract SeatGrade getSeatGrade();
}
