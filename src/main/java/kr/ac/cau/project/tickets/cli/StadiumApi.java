package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Stadium;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.StadiumRepository;

import java.util.Collections;
import java.util.List;

public class StadiumApi{
    @Autowired
    private static StadiumRepository StadiumRepository;

    static List<Stadium> findAllStadium(){
        return StadiumRepository.findAll();
    }
    static List<Stadium> findStadiumbyId(long id){
        return StadiumRepository.findAllById(Collections.singleton(id));
    }
}
