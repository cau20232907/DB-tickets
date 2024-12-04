package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.ReservedSeatTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedTicketRepository extends JpaRepository<ReservedSeatTicket, Long> {
    List<ReservedSeatTicket> findByConcertDate(ConcertDate concertDate);
}