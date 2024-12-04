package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.ConcertDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ConcertDateRepository extends JpaRepository<ConcertDate, Long> {
    List<ConcertDate> findByConcert(Concert concert);
}