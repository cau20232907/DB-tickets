package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.entity.Stadium;
import kr.ac.cau.project.tickets.repository.SeatGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeatGradeService {
    private final SeatGradeRepository seatGradeRepository;

    public List<SeatGrade> findByStadium(Stadium stadium) {
        return seatGradeRepository.findByStadium(stadium);
    }
}