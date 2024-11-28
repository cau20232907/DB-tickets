package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 좌석
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    private String seatName;
    @ManyToOne(fetch = FetchType.LAZY)
    private SeatGrade grade;
}