package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.entity.Ticket;
import kr.ac.cau.project.tickets.repository.EachTicketRepository;
import kr.ac.cau.project.tickets.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TicketService {
    private final TicketRepository ticketRepository;
    private final EachTicketRepository eachTicketRepository;

    public List<Ticket> findByPayment(Payment payment) {
        List<Ticket> result = ticketRepository.findByPaymentFetchConcert(payment);
        //우선은 이렇게 진행
        for (Ticket ticket : result) {
            ticket.getSeatGrade();
        }
        return result;
    }
}