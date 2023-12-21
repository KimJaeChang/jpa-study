package kr.co.kjc.study.jpastudy.jpa.lazy_loding.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class LazyLoadingTeam {

    @Id
    @GeneratedValue
    @Column(name = "lazy_loading_TEAM_ID")
    private Long id;

    @Column(name = "lazy_loading_TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "lazyLoadingTeam")
    private List<LazyLoadingMember> lazyLoadingMembers = new ArrayList<>();
}
