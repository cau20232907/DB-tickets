package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.ConcertDate;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.ConcertDateRepository;

import java.util.Collections;
import java.util.List;

public class ConcertDateApi{
    @Autowired
    private static ConcertDateRepository ConcertDateRepository;

    static List<ConcertDate> findAllConcertDate(){
        return ConcertDateRepository.findAll();
    }
    static List<ConcertDate> findConcertDatebyId(long id){
        return ConcertDateRepository.findAllById(Collections.singleton(id));
    }
}
