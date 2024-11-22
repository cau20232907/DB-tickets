package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public abstract class Userinfo {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
}