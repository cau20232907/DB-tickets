package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.NonpaidTicket;
import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    public void save(Payment payment, List<NonpaidTicket> targetTickets) {
        paymentRepository.save(payment);
        //TODO: paid로 전환
    }

    public List<Payment> findByMember(Member member) {
        return paymentRepository.findByMember(member);
    }
}