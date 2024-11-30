package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Seat;
import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class SeatApi{
    @Autowired
    private static SeatRepository SeatRepository;

    static List<Seat> findAllSeat(){
        return SeatRepository.findAll();
    }
    static List<Seat> findSeatbyId(long id){
        return SeatRepository.findAllById(Collections.singleton(id));
    }
    static List<Seat> findSeatbyGrade(SeatGrade selectedSeatGrade){
        return SeatRepository.findByGrade(selectedSeatGrade);
    }
}