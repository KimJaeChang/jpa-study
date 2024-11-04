package kr.co.kjc.study.jpastudy.jpa.one_to_one.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    private LocalDateTime createDate;
}
