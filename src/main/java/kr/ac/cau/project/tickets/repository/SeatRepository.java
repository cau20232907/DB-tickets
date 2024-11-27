package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Seat;
import kr.ac.cau.project.tickets.entity.SeatGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByGrade(SeatGrade grade);
}