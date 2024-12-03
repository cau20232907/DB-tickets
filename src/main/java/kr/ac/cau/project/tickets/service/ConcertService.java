package kr.ac.cau.project.tickets.service;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.EventStaff;
import kr.ac.cau.project.tickets.repository.ConcertDateRepository;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertService {
    private final ConcertRepository concertRepository;
    private final ConcertDateRepository concertDateRepository;

    public List<Concert> findByStaff(EventStaff staff) {
        List<Concert> concerts = concertRepository.findByStaffOrderByCastsAsc(staff);
        for (Concert concert : concerts) {
            concert.setDates(concertDateRepository.findByConcert(concert));
        }
        return concerts;
    }

    public Optional<Concert> findById(long id) {
        Optional<Concert> concertOptional = concertRepository.findById(id);
        if (concertOptional.isPresent()) {
            Concert concert = concertOptional.get();
            concert.setDates(concertDateRepository.findByConcert(concert));
            concertOptional=Optional.of(concert);
        }
        return concertOptional;
    }

    public Optional<Concert> findByIdFetchOnlyStaff(long id) {
        return concertRepository.findByIdFetchOnlyStaff(id);
    }

    @Transactional
    public void save(Concert concert) {
        concertRepository.save(concert);
    }
}
