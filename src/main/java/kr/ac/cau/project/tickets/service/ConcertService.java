package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertService {
    private final ConcertRepository concertRepository;

    public List<Concert> findAll() {
        return concertRepository.findAll();
    }
}
