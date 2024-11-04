package kr.co.kjc.study.jpastudy.jpa.one_to_one.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
public class OneToOneMemberLog {

    @Id
    @GeneratedValue
    @Column(name = "ONE_TO_ONE_MEMBER_LOG_ID")
    private Long oneToOneMemberId;

    @Column(name = "ONE_TO_ONE_MEMBER_LOG_USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ONE_TO_ONE_MEMBER_ID")
    private OneToOneMember oneToOneMember;

    @CreatedDate
    private LocalDateTime createDate;
}
