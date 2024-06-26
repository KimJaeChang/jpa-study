package kr.co.kjc.study.jpastudy.jpa.one_to_one.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OneToOneMember {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_ONE_MEMBER_ID")
    private Long oneToOneMemberId;

    @Column(name = "ONE_TO_ONE_MEMBER_USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "ONE_TO_ONE_LOCKER_ID")
    private OneToOneLocker oneToOneLocker;
}
