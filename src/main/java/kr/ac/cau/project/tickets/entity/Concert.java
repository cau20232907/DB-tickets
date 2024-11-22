package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Concert {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Stadium stadium;
    private String name;
    @ManyToOne
    private EventStaff staff;
    private String concertName;
    private String explaination;
}