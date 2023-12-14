package kr.co.kjc.study.jpastudy.jpa.ManyToMany.overcome.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ManyToManyMember {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_MEMBER_ID")
    private Long manyToManyMemberId;

    @Column(name = "MANY_TO_MANY_MEMBER_USERNAME")
    private String username;

    @OneToMany(mappedBy = "manyToManyProduct")
    private List<ManyToManyMemberProduct> manyToManyProducts = new ArrayList<>();
}
