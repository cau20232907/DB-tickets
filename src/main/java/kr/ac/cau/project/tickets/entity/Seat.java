package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    private String seatName;
    @ManyToOne
    private SeatGrade grade;
}