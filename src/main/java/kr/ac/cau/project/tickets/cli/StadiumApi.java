package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Stadium;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StadiumApi{
    @Autowired
    private static StadiumRepository StadiumRepository;

    public StadiumApi(StadiumRepository stadiumRepository){
        StadiumApi.StadiumRepository = stadiumRepository;
    }

    static List<Stadium> findAllStadium(){
        return StadiumRepository.findAll();
    }
    static List<Stadium> findStadiumbyId(long id){
        return StadiumRepository.findAllById(Collections.singleton(id));
    }
}
