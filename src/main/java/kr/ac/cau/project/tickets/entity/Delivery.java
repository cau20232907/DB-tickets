package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * 간단하게 만들기 위해 배송은 다른 회사에 위탁하고
 * 그 정보만 저장함
 */
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private String deliveryCompany;
    private String arrivalAddress;
    private String deliveryCode;
}