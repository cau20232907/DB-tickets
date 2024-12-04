package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 공연날짜(스케쥴)
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseballDate {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Baseball baseball;
    private LocalDateTime startTime;
}