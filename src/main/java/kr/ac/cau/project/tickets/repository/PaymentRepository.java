package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByMember(Member member);
}