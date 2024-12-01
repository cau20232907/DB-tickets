package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.FreeSeatNonpaidTicket;
import kr.ac.cau.project.tickets.entity.NonpaidTicket;
//import kr.ac.cau.project.tickets.repository.FreeSeatNonpaidTicketRepository;
import kr.ac.cau.project.tickets.repository.NonpaidTicketRepository;
import kr.ac.cau.project.tickets.repository.EachNonpaidTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeSeatNonpaidTicketApi {
    @Autowired
    private static NonpaidTicketRepository NonpaidTicketRepository;
    private static EachNonpaidTicketRepository fsNonpaidTicketRepository;
    //private static FreeSeatNonpaidTicketRepository fsNonpaidTicketRepository;

    static void insert(FreeSeatNonpaidTicket fsNonpaidSeat){
        //fsNonpaidTicketRepository.saveAndFlush(fsNonpaidSeat); //saveAndFlush??
        fsNonpaidTicketRepository.insertFreeSeatNonpaidTicket(fsNonpaidSeat);
    }
}
