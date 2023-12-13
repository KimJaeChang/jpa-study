package kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ManyToManyTeam {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_TEAM_ID")
    private Long id;

    @Column(name = "MANY_TO_MANY_TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "manyToManyTeam")
    private List<ManyToManyMember> manyToManyMembers = new ArrayList<>();

}
