package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 공연
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "etype")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {
    @Id
    @GeneratedValue
    private Long id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Stadium stadium;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventStaff staff;
    private String concertName;
    private String explaination;
}