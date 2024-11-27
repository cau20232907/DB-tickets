package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.TransactionQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionQueueRepository extends JpaRepository<TransactionQueue, Long> {

}