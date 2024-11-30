package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.EventStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    List<Concert> findByStaff(EventStaff staff);

}