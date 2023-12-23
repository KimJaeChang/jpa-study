package kr.co.kjc.study.jpastudy.jpa.embedded.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class EmbeddedTeam {

    @Id
//    @GeneratedValue
    @Column(name = "TEAMID")
    private String teamId;

    @Column(name = "TEAMNAME")
    private String name;

    @OneToMany(targetEntity = EmbeddedMember.class, mappedBy = "memberTeam")
    private List<EmbeddedMember> members = new ArrayList<>();
}
