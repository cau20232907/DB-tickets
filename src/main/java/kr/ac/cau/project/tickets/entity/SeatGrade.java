package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SeatGrade {
    @Id
    @GeneratedValue
    private Long id;
    private String gradeName;
    @ManyToOne
    private Stadium stadium;
}