package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 임시 멤버
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("T")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@AllArgsConstructor
public class TemporalMember extends Userinfo {
    //연락처 등이 들어갈 수 있음
}