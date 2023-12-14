package kr.co.kjc.study.jpastudy.jpa.OneToOne.domain;

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
    private Long id;

    @Column(name = "ONE_TO_ONE_USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "ONE_TO_ONE_LOCKER_ID")
    private OneToOneLocker oneToOneLocker;
}
