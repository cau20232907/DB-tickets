package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.DiscountOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountOptionsRepository extends JpaRepository<DiscountOptions, Long> {
}