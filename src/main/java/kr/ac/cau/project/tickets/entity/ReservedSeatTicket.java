package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * 지정석티켓
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("R")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public class ReservedSeatTicket extends Ticket {
    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;

    @Override
    public SeatGrade getSeatGrade() {
        return getSeat().getGrade();
    }
}