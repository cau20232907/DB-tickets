package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * 비밀번호 분리해서 저장
 * (7주차 강의 내용)
 */
@Entity
public class Credential {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne //소셜로그인을 도입하거나 2차인증을 도입하면 ManyToOne이 맞음
    private Userinfo userinfo;
    private String salt;
    private String hashValue;
}