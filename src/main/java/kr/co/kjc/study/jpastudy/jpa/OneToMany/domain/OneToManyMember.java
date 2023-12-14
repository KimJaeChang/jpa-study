package kr.co.kjc.study.jpastudy.jpa.OneToMany.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OneToManyMember {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_MANY_MEMBER_ID")
    private Long oneToManyMemberId;

    @Column(name = "ONE_TO_MANY_MEMBER_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "ONE_TO_MANY_TEAM_ID", insertable = false, updatable = false)   // 일대다 양방향 시 insertable, updatable 필수! (읽기 전용)
    private OneToManyTeam oneToManyTeam;
}
