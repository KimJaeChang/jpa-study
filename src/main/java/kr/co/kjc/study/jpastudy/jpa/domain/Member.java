package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
//    @GeneratedValue
    @Column(name = "USERID")
    private String id;
    @Column(name = "USERNAME")
    private String name;

    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)   // @JoinColumn없이 targetEntity만 매칭시키면 entity의 @Id 변수명을 따라간다. 주의!!!!
    @JoinColumn(name = "team_id")
//    @JoinColumn(name = "team_teamid") // error -> name 공식은 Team entity의 @id를 찾도록 entity_id로 항상 매핑해야하나?
    private Team memberTeam;
}
