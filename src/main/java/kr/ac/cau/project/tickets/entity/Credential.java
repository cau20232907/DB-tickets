package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 비밀번호 분리해서 저장
 * (7주차 강의 내용)
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY) //소셜로그인을 도입하거나 2차인증을 도입하면 ManyToOne이 맞음
    private Userinfo userinfo;
    private String salt;
    private String hashValue;
}