package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import java.util.List;

public class ConcertApi {
    @Autowired
    private static ConcertRepository ConcertRepository;

    static List<Concert> findAllConcert(){
        return ConcertRepository.findAll();
    }
}
