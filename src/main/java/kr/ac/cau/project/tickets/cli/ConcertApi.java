package kr.ac.cau.project.tickets.cli;

import kr.ac.cau.project.tickets.entity.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ConcertApi {

    @Autowired
    private static ConcertRepository ConcertRepository;

    public ConcertApi(ConcertRepository concertRepository){
        ConcertApi.ConcertRepository = concertRepository;
    }

    public static List<Concert> findAllConcert(){
        return ConcertRepository.findAll();
    }
}
