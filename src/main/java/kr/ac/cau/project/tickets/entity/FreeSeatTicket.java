package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 스탠딩티켓
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("F")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public class FreeSeatTicket extends Ticket {
    public FreeSeatTicket(FreeSeatNonpaidTicket nonpaidTicket, Payment payment) {
        super(nonpaidTicket.getId(), payment, nonpaidTicket.getConcertDate(),
                nonpaidTicket.getPurchaseTime(), nonpaidTicket.getIsOnline(), null);
        this.seat = nonpaidTicket.getSeat();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private SeatGrade seat;

    @Override
    public SeatGrade getSeatGrade() {
        return getSeat();
    }
}