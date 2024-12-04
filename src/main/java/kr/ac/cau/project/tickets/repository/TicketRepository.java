package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByPayment(Payment payment);

    @Query("select t from Ticket t join fetch t.concertDate d join fetch d.concert c" +
            " join fetch t.payment p left join fetch p.selectedDiscountOptions do where p=:payment")
    List<Ticket> findByPaymentFetchConcert(Payment payment);

    List<Ticket> findByConcertDate(ConcertDate concertDate);
}