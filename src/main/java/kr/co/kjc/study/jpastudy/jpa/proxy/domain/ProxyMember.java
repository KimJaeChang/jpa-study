package kr.co.kjc.study.jpastudy.jpa.proxy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProxyMember {

    @Id
    @GeneratedValue
    @Column(name = "PROXY_MEMBER_ID")
    private Long proxyMemberId;

    @Column(name = "PROXY_MEMBER_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "PROXY_TEAM_ID")
    private ProxyTeam proxyTeam;
}
