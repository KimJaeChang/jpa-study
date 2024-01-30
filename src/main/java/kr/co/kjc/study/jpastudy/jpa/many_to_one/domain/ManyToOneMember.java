package kr.co.kjc.study.jpastudy.jpa.many_to_one.domain;

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
    private Long manyToOneMemberId;

    @Column(name = "MANY_TO_ONE_MEMBER_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "MANY_TO_ONE_TEAM_ID")
    private ManyToOneTeam manyToOneTeam;

    public void changeManyToOneTeam(ManyToOneTeam manyToOneTeam) { // 양방향 매핑시 연관관계 편의 메소드를 생성
        this.manyToOneTeam = manyToOneTeam;
        manyToOneTeam.getManyToOneMembers().add(this);  // join된 ManyToOneTeam에도 값을 넣어줘야 하기 때문
    }

}
