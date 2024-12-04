package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 좌석등급
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatGrade {
    @Id
    @GeneratedValue
    private Long id;
    private String gradeName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;

    //추가
    private int price;
    private Boolean isFree;
}