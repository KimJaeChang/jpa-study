package kr.co.kjc.study.jpastudy.jpql.domain;

import jakarta.persistence.*;
import kr.co.kjc.study.jpastudy.jpql.enums.JpqlMemberType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JpqlMember {

    @Id
    @GeneratedValue
    @Column(name = "JPQL_MEMBER_ID")
    private Long id;

    private String sex;

    private String username;
    private int age;
    @ManyToOne
    @JoinColumn(name = "JPQL_TEAM_ID")
    private JpqlTeam jpqlTeam;

    @Enumerated(EnumType.STRING)
    private JpqlMemberType memberType;
}
