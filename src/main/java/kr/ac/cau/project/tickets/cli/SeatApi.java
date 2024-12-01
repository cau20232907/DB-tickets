package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Seat;
import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import kr.ac.cau.project.tickets.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SeatApi{
    @Autowired
    private static SeatRepository SeatRepository;

    public SeatApi(SeatRepository seatRepository){
        SeatApi.SeatRepository = seatRepository;
    }

    static List<Seat> findAllSeat(){
        return SeatRepository.findAll();
    }
    static List<Seat> findSeatbyGrade(SeatGrade selectedSeatGrade){
        return SeatRepository.findByGrade(selectedSeatGrade);
    }
}