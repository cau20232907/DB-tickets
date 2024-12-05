package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 결제 기록
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private DiscountOptions selectedDiscountOptions;
    private String paymentCode;
    //일단 자리를 고르고 결제하기에, ticket 시간과 payment 시간이 다를 수 있음
    private LocalDateTime paymentTime;
    private int totalBalance;
    //변경 시각
    private LocalDateTime changeTime;
    //이 시간 이후에 지워졌는가
    private Boolean deleted;
}