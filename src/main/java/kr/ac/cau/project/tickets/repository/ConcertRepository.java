package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    //List<Concert> findAllConcert();

}