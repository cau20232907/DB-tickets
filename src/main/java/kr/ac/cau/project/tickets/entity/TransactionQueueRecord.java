package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * TransactionQueue 기록
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionQueueRecord {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime time; //요청한 시간, 이게 ticket의 시간이 됨
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private ConcertDate concertDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private SeatGrade seatGrade;
    @ManyToOne(fetch = FetchType.LAZY)
    private Seat seat;
    private Boolean ifSucceed;
}