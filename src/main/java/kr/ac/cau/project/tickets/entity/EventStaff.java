package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class EventStaff extends Userinfo{
    //회사 이름, 사업자등록번호 등이 들어갈 수 있음
}