package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 자유석 인원 제한
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeSeatLimit {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private SeatGrade seatGrade;
    private int value;
}