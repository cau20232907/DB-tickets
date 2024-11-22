package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Stadium {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String explaination;
}