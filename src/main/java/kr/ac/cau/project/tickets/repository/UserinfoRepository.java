package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
    //Optional 사용 방법 확인 먼저
    Optional<Userinfo> findByUsername(String username);
}