package kr.co.kjc.study.jpastudy.jpa.proxy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProxyTeam {

    @Id
    @GeneratedValue
    @Column(name = "PROXY_TEAM_ID")
    private Long id;

    @Column(name = "PROXY_TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "proxyTeam")
    private List<ProxyMember> proxyMembers = new ArrayList<>();
}
