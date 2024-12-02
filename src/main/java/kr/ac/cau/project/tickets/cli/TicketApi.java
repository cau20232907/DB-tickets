package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Payment;
import kr.ac.cau.project.tickets.entity.Ticket;
import kr.ac.cau.project.tickets.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketApi {
    @Autowired
    private static TicketRepository TicketRepository;

    public TicketApi(TicketRepository ticketRepository){
        TicketApi.TicketRepository = ticketRepository;
    }

    static List<Ticket> findTicketByPayment(Payment payment){
        return TicketRepository.findByPayment(payment);
    }

    static void insert(Ticket ticket){
        TicketRepository.saveAndFlush(ticket);
    }
}
