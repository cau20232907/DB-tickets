package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.ConcertDate;
import kr.ac.cau.project.tickets.repository.ConcertDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertDateService {
    private final ConcertDateRepository concertDateRepository;

    public List<ConcertDate> findByConcert(Concert concert) {
        return concertDateRepository.findByConcert(concert);
    }
}
