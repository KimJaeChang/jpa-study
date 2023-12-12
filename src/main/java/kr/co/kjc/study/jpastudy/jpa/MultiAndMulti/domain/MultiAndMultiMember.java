package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain;

import jakarta.persistence.*;
import kr.co.kjc.study.jpastudy.jpa.MultiAndOne.domain.MultiAndOneTeam;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MultiAndMultiMember {

    @Id
    @GeneratedValue
    @Column(name = "MULTI_AND_MULTI_MEMBER_ID")
    private Long id;

    @Column(name = "MULTI_AND_MULTI_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "MULTI_AND_MULTI_TEAM_ID")
    private MultiAndMultiTeam multiAndMultiTeam;

}
