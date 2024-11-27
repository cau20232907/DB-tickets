package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.SeatGrade;
import kr.ac.cau.project.tickets.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatGradeRepository extends JpaRepository<SeatGrade, Long> {
    List<SeatGrade> findByStadium(Stadium stadium);
}