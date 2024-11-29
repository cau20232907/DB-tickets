package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * 공연관리자
 * 추가 column을 추가할 수 있음
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("S")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@AllArgsConstructor
public class EventStaff extends Userinfo{
    //회사 이름, 사업자등록번호 등이 들어갈 수 있음
}