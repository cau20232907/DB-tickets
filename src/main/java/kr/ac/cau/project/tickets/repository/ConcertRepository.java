package kr.ac.cau.project.tickets.repository;

import kr.ac.cau.project.tickets.entity.Concert;
import kr.ac.cau.project.tickets.entity.EventStaff;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
//    @Query("select c from Concert c join fetch c.casts ca join fetch c.stadium s"
//            + " where c.staff=:staff order by ca.seqOrder asc")
    @EntityGraph(attributePaths = {"casts", "stadium"})
    List<Concert> findByStaffOrderByCastsAsc(EventStaff staff);

    @EntityGraph(attributePaths = {"casts", "stadium", "staff"})
    Optional<Concert> findById(Long id);

    @Query("select c from Concert c join fetch c.staff s where c.id=:id")
    Optional<Concert> findByIdFetchOnlyStaff(Long id);
}