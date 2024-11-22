package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class ConcertDate {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Concert concert;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}