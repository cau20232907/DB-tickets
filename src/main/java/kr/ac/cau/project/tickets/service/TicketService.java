package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.*;
import kr.ac.cau.project.tickets.repository.EachTicketRepository;
import kr.ac.cau.project.tickets.repository.ReservedTicketRepository;
import kr.ac.cau.project.tickets.repository.TicketPurchaseLimitRepository;
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
    private final ReservedTicketRepository reservedTicketRepository;
    private final TicketPurchaseLimitRepository ticketPurchaseLimitRepository;

    public List<Ticket> findByPayment(Payment payment) {
        List<Ticket> result = ticketRepository.findByPaymentFetchConcert(payment);
        //우선은 이렇게 진행
        for (Ticket ticket : result) {
            ticket.getSeatGrade().getPrice();
        }
        return result;
    }

    public List<Ticket> findByConcertDate(ConcertDate concertDate) {
        List<Ticket> result = ticketRepository.findByConcertDate(concertDate);
        //우선은 이렇게 진행
        for (Ticket ticket : result) {
            ticket.getSeatGrade();
        }
        return result;
    }

    public List<ReservedSeatTicket> findByConcertDateOnlyReservedSeat(ConcertDate concertDate) {
        List<ReservedSeatTicket> result = reservedTicketRepository.findByConcertDate(concertDate);
        //우선은 이렇게 진행
        for (Ticket ticket : result) {
            ticket.getSeatGrade();
        }
        return result;
    }

    public TicketPurchaseLimit getTicketPurchaseLimit() {
        List<TicketPurchaseLimit> all = ticketPurchaseLimitRepository.findAll();
        if (all.size() == 0) {
            return TicketPurchaseLimit.builder().value(4).build();
        } else return all.getFirst();
    }
}