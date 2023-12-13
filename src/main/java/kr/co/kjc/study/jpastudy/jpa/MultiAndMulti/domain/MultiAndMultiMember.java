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

    public void changeMultiAndMultiTeam(MultiAndMultiTeam multiAndMultiTeam) { // 양방향 매핑시 연관관계 편의 메소드를 생성
        this.multiAndMultiTeam = multiAndMultiTeam;
        multiAndMultiTeam.getMultiAndMultiMembers().add(this);  // join된 multiAndMultiTeam에도 값을 넣어줘야 하기 때문
    }

}
