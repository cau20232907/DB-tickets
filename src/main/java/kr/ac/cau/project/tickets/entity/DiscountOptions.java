package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DiscountOptions {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private double discountRate;
}