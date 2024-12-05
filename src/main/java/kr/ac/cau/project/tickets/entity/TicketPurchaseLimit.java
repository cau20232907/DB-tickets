package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketPurchaseLimit {
    @Id
    private int value;
    //회원 등급이 있으면 나눌 수 있겠으나, 없으므로 scalar 형태로 만듦
    //현재 구현상 항상 4 값을 가짐
}