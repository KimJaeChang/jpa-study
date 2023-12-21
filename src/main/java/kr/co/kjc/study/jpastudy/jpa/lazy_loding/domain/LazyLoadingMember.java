package kr.co.kjc.study.jpastudy.jpa.lazy_loding.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LazyLoadingMember {

    @Id
    @GeneratedValue
    @Column(name = "lazy_loaging_member_id")
    private Long id;

    @Column(name = "lazy_loading_member_username")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lazy_loading_team_id")
    private LazyLoadingTeam lazyLoadingTeam;

}
