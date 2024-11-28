package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 할인 옵션
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountOptions {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private double discountRate;
}