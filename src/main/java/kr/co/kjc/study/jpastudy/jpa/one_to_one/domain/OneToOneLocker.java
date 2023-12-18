package kr.co.kjc.study.jpastudy.jpa.one_to_one.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OneToOneLocker {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_ONE_LOCKER_ID")
    private Long id;

    @Column(name = "ONE_TO_ONE_LOCKER_NAME")
    private String name;

    @OneToOne(mappedBy = "oneToOneLocker")
    private OneToOneMember oneToOneMember;
}
