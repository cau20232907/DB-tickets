package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.ConcertDateRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ConcertDateApi{

    @Autowired
    private static ConcertDateRepository ConcertDateRepository;

    public ConcertDateApi(ConcertDateRepository concertDateRepository){
        ConcertDateApi.ConcertDateRepository = concertDateRepository;
    }

    public static List<ConcertDate> findConcertDatebyConcert(Concert concert){
        return ConcertDateRepository.findByConcert(concert);
    }
    public static List<ConcertDate> findConcertDatebyId(long id){
        return ConcertDateRepository.findAllById(Collections.singleton(id));
    }
}
