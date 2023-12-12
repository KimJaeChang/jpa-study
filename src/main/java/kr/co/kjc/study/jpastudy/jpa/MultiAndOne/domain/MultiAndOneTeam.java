package kr.co.kjc.study.jpastudy.jpa.MultiAndOne.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MultiAndOneTeam {

    @Id
    @GeneratedValue
    @Column(name = "MULTI_AND_ONE_TEAM_ID")
    private Long id;

    @Column(name = "MULTI_AND_ONE_TEAM_NAME")
    private String name;

}
