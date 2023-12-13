package kr.co.kjc.study.jpastudy.jpa.ManyToOne.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ManyToOneMember {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_ONE_MEMBER_ID")
    private Long id;

    @Column(name = "MANY_TO_ONE_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "MANY_TO_ONE_TEAM_ID")
    private ManyToOneTeam manyToOneTeam;

}
