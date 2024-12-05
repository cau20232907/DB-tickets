package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Userinfo;
import kr.ac.cau.project.tickets.entity.UserinfoLoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserinfoLoginRecordRepository extends JpaRepository<UserinfoLoginRecord, Long> {
    List<UserinfoLoginRecord> findByUserinfo(Userinfo userinfo);
}