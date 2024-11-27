package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    //User, Stadium으로 찾는 기능 필요
}