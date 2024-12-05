package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.repository.NonpaidTicketRepository;
import kr.ac.cau.project.tickets.repository.PaymentRepository;
import kr.ac.cau.project.tickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final NonpaidTicketRepository nonpaidTicketRepository;
    private final TicketRepository ticketRepository;

    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    public void save(Payment payment, List<NonpaidTicket> targetTickets) {
        paymentRepository.save(payment);
        // paid로 전환
        List<Ticket> paidTicket = targetTickets.stream().map(nonpaidTicket -> {
            if (nonpaidTicket instanceof ReservedSeatNonpaidTicket reservedSeatNonpaidTicket) {
                return new ReservedSeatTicket(reservedSeatNonpaidTicket, payment);
            } else if (nonpaidTicket instanceof FreeSeatNonpaidTicket freeSeatNonpaidTicket) {
                return new FreeSeatTicket(freeSeatNonpaidTicket, payment);
            }
            throw new RuntimeException("unexpected type");
        }).toList();
        ticketRepository.saveAll(paidTicket);
        nonpaidTicketRepository.deleteAll(targetTickets);
    }

    public List<Payment> findByMember(Member member) {
        return paymentRepository.findByMember(member);
    }
}