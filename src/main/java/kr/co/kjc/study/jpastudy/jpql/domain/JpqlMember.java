package kr.co.kjc.study.jpastudy.jpql.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class JpqlMember {

    @Id
    @GeneratedValue
    @Column(name = "JPQL_MEMBER_ID")
    private Long id;
    private String username;
    private int age;
    @ManyToOne
    @JoinColumn(name = "JPQL_TEAM_ID")
    private JpqlTeam jpqlTeam;
}
