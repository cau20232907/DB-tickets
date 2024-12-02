package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.NonpaidTicket;
import kr.ac.cau.project.tickets.repository.NonpaidTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonpaidTicketApi {
    @Autowired
    private static NonpaidTicketRepository NonpaidTicketRepository;

    public NonpaidTicketApi(NonpaidTicketRepository nonpaidTicketRepository){
        NonpaidTicketApi.NonpaidTicketRepository = nonpaidTicketRepository;
    }

    static void insert(NonpaidTicket nonpaidTicket){
        NonpaidTicketRepository.saveAndFlush(nonpaidTicket);
    }
}
