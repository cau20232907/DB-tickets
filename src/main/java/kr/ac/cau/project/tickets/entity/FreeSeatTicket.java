package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("F")
public class FreeSeatTicket extends Ticket {
    @ManyToOne
    private SeatGrade seat;
}