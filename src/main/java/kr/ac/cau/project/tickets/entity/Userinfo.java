package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import kr.ac.cau.project.tickets.repository.ConcertRepository;
import kr.ac.cau.project.tickets.repository.UserinfoRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 회원
 * 이 자체로 사용할 수 없고, Member나 EventStaff로 사용해야 함
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
public abstract class Userinfo {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
}