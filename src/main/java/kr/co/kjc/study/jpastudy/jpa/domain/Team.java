package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id
//    @GeneratedValue
    @Column(name = "TEAMID")
    private String teamId;

    @Column(name = "TEAMNAME")
    private String name;

    @OneToMany(targetEntity = Member.class, mappedBy = "memberTeam")
    private List<Member> members = new ArrayList<>();
}
