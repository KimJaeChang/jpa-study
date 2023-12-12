package kr.co.kjc.study.jpastudy.jpa.MultiAndOne.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MultiAndOneMember {

    @Id
    @GeneratedValue
    @Column(name = "MULTI_AND_ONE_MEMBER_ID")
    private Long id;

    @Column(name = "MULTI_AND_ONE_USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MULTI_AND_ONE_TEAM_ID")
    private MultiAndOneTeam team;

}
