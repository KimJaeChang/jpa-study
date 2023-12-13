package kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ManyToManyMember {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_MEMBER_ID")
    private Long id;

    @Column(name = "MANY_TO_MANY_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "MANY_TO_MANY_TEAM_ID")
    private ManyToManyTeam manyToManyTeam;

    public void changeManyToManyTeam(ManyToManyTeam manyToManyTeam) { // 양방향 매핑시 연관관계 편의 메소드를 생성
        this.manyToManyTeam = manyToManyTeam;
        manyToManyTeam.getManyToManyMembers().add(this);  // join된 ManyToManyTeam에도 값을 넣어줘야 하기 때문
    }

}
