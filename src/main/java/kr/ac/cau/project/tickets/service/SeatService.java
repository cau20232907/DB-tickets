package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.entity.ReservedSeatTicket;
import kr.ac.cau.project.tickets.entity.Seat;
import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.repository.ReservedTicketRepository;
import kr.ac.cau.project.tickets.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeatService {
    private final SeatRepository seatRepository;
    private final ReservedTicketRepository reservedTicketRepository;

    public List<Seat> findByGrade(SeatGrade grade) {
        return seatRepository.findByGrade(grade);
    }

    public List<Seat> findRemainingByGrade(ConcertDate concertDate, SeatGrade grade) {
        List<Seat> allResult = seatRepository.findByGrade(grade);
        List<Seat> reservedResult = reservedTicketRepository.findByConcertDate(concertDate).stream()
                .map(ReservedSeatTicket::getSeat).toList();
        allResult.removeAll(reservedResult);
        return allResult;
    }
}