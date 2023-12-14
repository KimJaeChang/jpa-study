package kr.co.kjc.study.jpastudy.jpa.OneToMany.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class OneToManyTeam {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_MANY_TEAM_ID")
    private Long id;

    @Column(name = "ONE_TO_MANY_TEAM_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "ONE_TO_MANY_TEAM_ID")
    private List<OneToManyMember> members = new ArrayList<>();

}
