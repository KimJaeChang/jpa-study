package kr.co.kjc.study.jpastudy.jpa.one_to_one.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ONE_TO_ONE_LOCKER_ID")
    private OneToOneLocker oneToOneLocker;

    @OneToMany(mappedBy = "oneToOneMember")
    private List<OneToOneMemberLog> oneToOneMemberLog = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createDate;
}
