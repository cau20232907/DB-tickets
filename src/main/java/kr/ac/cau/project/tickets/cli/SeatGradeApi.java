package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.repository.SeatGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class SeatGradeApi{
    @Autowired
    private static SeatGradeRepository SeatGradeRepository;

    static List<SeatGrade> findAllSeatGrade(){
        return SeatGradeRepository.findAll();
    }
    static List<SeatGrade> findSeatGradebyId(long id){
        return SeatGradeRepository.findAllById(Collections.singleton(id));
    }
}
