package kr.co.kjc.study.jpastudy.jpa.many_to_one.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ManyToOneTeam {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_ONE_TEAM_ID")
    private Long id;

    @Column(name = "MANY_TO_ONE_TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "manyToOneTeam")
    private List<ManyToOneMember> manyToOneMembers = new ArrayList<>();
}
