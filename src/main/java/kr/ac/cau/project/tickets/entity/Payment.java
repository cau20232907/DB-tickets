package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private DiscountOptions selectedDiscountOptions;
    private String paymentCode;
    //일단 자리를 고르고 결제하기에, ticket 시간과 payment 시간이 다를 수 있음
    private LocalDateTime paymentTime;
    private int totalBalance;
}