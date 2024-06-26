package kr.co.kjc.study.jpastudy.jpa.jpql.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class JpqlTeam {

    @Id
    @GeneratedValue
    @Column(name = "JPQL_TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "jpqlTeam")
    private List<JpqlMember> jpqlMembers = new ArrayList<>();
}
