package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public abstract class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ConcertDate concertDate;
    private LocalDateTime purchaseTime;
    private Boolean isOnline;
    @ManyToOne //여러 티켓이 한 번에 배송될 수 있음
    private Delivery delivery;
}