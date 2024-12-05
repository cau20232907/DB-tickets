package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.TicketPurchaseLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPurchaseLimitRepository extends JpaRepository<TicketPurchaseLimit, Long> {
}