package kr.ac.cau.project.tickets.repository;

import jakarta.persistence.EntityManager;
import kr.ac.cau.project.tickets.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EachTicketRepository {
    private final EntityManager em;

    public List<ReservedSeatTicket> findByConcertDateAndSeat(ConcertDate concertDate, Seat seat) {
        return em.createQuery
                        ("select t from ReservedSeatTicket t where t.concertDate=:concertDate and t.seat=:seat",
                                ReservedSeatTicket.class)
                .setParameter("concertDate",concertDate)
                .setParameter("seat",seat)
                .getResultList();
    }

    public List<FreeSeatTicket> findByConcertDateAndSeat(ConcertDate concertDate, SeatGrade seatGrade) {
        return em.createQuery
                        ("select t from FreeSeatTicket t where t.concertDate=:concertDate and t.seat=:seat",
                                FreeSeatTicket.class)
                .setParameter("concertDate",concertDate)
                .setParameter("seat",seatGrade)
                .getResultList();
    }
}