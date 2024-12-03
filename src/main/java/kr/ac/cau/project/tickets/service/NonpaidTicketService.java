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

    public List<NonpaidTicket> findByMember(Member member) {
        return nonpaidTicketRepository.findByMember(member);
    }
}