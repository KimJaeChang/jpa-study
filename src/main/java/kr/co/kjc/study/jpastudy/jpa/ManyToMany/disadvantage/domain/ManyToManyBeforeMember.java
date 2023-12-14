package kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ManyToManyBeforeMember {

    @Id
    @GeneratedValue
    @Column(name = "MANY_TO_MANY_MEMBER_ID")
    private Long manyToManyBeforeMemberId;

    @Column(name = "MANY_TO_MANY_MEMBER_USERNAME")
    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCTS")
    private List<ManyToManyBeforeProduct> manyToManyBeforeProducts = new ArrayList<>();
}
