package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class MultiAndMultiTeam {

    @Id
    @GeneratedValue
    @Column(name = "MULTI_AND_ONE_TEAM_ID")
    private Long id;

    @Column(name = "MULTI_AND_ONE_TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "multiAndMultiTeam")
    private List<MultiAndMultiMember> multiAndMultiMembers = new ArrayList<>();

}
