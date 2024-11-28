package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 결제
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private DiscountOptions selectedDiscountOptions;
    private String paymentCode;
    //일단 자리를 고르고 결제하기에, ticket 시간과 payment 시간이 다를 수 있음
    private LocalDateTime paymentTime;
    private int totalBalance;
}