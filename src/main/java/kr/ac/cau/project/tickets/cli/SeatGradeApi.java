package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.entity.Stadium;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import kr.ac.cau.project.tickets.repository.SeatGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SeatGradeApi{
    @Autowired
    private static SeatGradeRepository SeatGradeRepository;

    public SeatGradeApi(SeatGradeRepository seatGradeRepository){
        SeatGradeApi.SeatGradeRepository = seatGradeRepository;
    }

    static List<SeatGrade> findAllSeatGrade(){
        return SeatGradeRepository.findAll();
    }
    static List<SeatGrade> findSeatGradebyStadium(Stadium stadium){
        return SeatGradeRepository.findByStadium(stadium);
    }
}
