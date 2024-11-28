package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 배송정보
 * 간단하게 만들기 위해 배송은 다른 회사에 위탁하고
 * 그 정보만 저장함
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private String deliveryCompany;
    private String arrivalAddress;
    private String deliveryCode;
}