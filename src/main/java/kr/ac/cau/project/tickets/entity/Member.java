package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * 회원(일반회원)
 * 추가 column을 추가할 수 있음
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("M")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends Userinfo{
    //이름, 연락처 등이 들어갈 수 있음
}