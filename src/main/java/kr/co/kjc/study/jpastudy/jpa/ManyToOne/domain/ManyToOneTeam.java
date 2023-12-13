package kr.co.kjc.study.jpastudy.jpa.ManyToOne.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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

}
