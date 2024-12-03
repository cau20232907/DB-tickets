package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.NonpaidTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonpaidTicketRepository extends JpaRepository<NonpaidTicket, Long>{
    List<NonpaidTicket> findByConcertDate(ConcertDate concertDate);

    List<NonpaidTicket> findByMember(Member member);
}
