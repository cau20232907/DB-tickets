package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import kr.ac.cau.project.tickets.repository.ConcertDateRepository;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 공연
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concert {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private EventStaff staff;
    private String concertName;
    private String explaination;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcertDate> dates = new ArrayList<>();
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cast> casts = new ArrayList<>();
}