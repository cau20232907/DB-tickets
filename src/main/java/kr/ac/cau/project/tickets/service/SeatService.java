package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Seat;
import kr.ac.cau.project.tickets.entity.SeatGrade;
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

    public List<Seat> findByGrade(SeatGrade grade) {
        return seatRepository.findByGrade(grade);
    }
}