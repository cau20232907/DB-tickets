package kr.ac.cau.project.tickets.repository;

import jakarta.persistence.EntityManager;
import kr.ac.cau.project.tickets.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EachNonpaidTicketRepository    {
    private final EntityManager em;

    public List<ReservedSeatNonpaidTicket> findByConcertDateAndSeat(ConcertDate concertDate, Seat seat) {
        return em.createQuery
                        ("select t from ReservedSeatNonpaidTicket t where t.concertDate=:concertDate and t.seat=:seat",
                                ReservedSeatNonpaidTicket.class)
                .setParameter("concertDate",concertDate)
                .setParameter("seat",seat)
                .getResultList();
    }

    public List<FreeSeatNonpaidTicket> findByConcertDateAndSeat(ConcertDate concertDate, SeatGrade seatGrade) {
        return em.createQuery
                        ("select t from FreeSeatNonpaidTicket t where t.concertDate=:concertDate and t.seat=:seat",
                                FreeSeatNonpaidTicket.class)
                .setParameter("concertDate",concertDate)
                .setParameter("seat",seatGrade)
                .getResultList();
    }

    public void insertFreeSeatNonpaidTicket(FreeSeatNonpaidTicket fsNonpaidTicket){
        em.createQuery("insert into FreeSeatNonpaidTicket(concertDate, isOnline, delivery, purchaseTime, seat) " +
                "values ("+fsNonpaidTicket.getConcertDate()+","
                +fsNonpaidTicket.getIsOnline()+","
                +fsNonpaidTicket.getDelivery()+","
                +fsNonpaidTicket.getPurchaseTime()+","
                +fsNonpaidTicket.getSeat()+")");
    }
}
