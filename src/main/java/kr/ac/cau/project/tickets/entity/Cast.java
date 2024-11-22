package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cast {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Concert event;
    private byte seqOrder;
}