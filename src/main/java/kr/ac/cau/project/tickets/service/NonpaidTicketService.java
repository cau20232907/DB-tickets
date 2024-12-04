package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Member;
import kr.ac.cau.project.tickets.entity.NonpaidTicket;
import kr.ac.cau.project.tickets.repository.EachNonpaidTicketRepository;
import kr.ac.cau.project.tickets.repository.NonpaidTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NonpaidTicketService {
    private final NonpaidTicketRepository nonpaidTicketRepository;
    private final EachNonpaidTicketRepository eachNonpaidTicketRepository;

    @Transactional(readOnly = true)
    public List<NonpaidTicket> findByMember(Member member) {
        //임시로 이렇게 처리
        List<NonpaidTicket> tickets = nonpaidTicketRepository.findByMember(member);
        for (NonpaidTicket ticket : tickets) {
            ticket.getSeatGrade().getPrice();
        }
        return tickets;
    }
}