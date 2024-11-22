package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("R")
public class ReservedSeatTicket extends Ticket {
    @ManyToOne
    private Seat seat;
}