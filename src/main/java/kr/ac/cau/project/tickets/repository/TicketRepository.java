package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByPayment(Payment payment);

    List<Ticket> findByConcertDate(ConcertDate concertDate);
}