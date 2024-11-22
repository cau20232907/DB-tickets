package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Member extends Userinfo{
    //이름, 연락처 등이 들어갈 수 있음
}