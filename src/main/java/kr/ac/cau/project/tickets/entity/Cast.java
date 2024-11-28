package kr.ac.cau.project.tickets.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * 공연자, 공연순서
 */
@Entity
@Data //우선 전부 연 후 나중에 닫음, 팀원의 Java 이해도 고려
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cast {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Concert event;
    private byte seqOrder;
}