package kr.co.kjc.study.jpastudy.jpa.many_to_many.overcome.domain;

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

    @OneToMany(mappedBy = "manyToManyMember")
    private List<ManyToManyMemberProduct> manyToManyMemberMembers = new ArrayList<>();
}
