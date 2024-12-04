package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    Stadium findByName(String name); // 관리자가 새로 concert 객체를 만들 때 사용
}