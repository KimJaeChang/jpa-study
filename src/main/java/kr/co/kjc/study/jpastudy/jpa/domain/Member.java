package kr.co.kjc.study.jpastudy.jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "USERID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;

    @Embedded
    private Address address;

    @ManyToOne(targetEntity = Team.class, fetch = FetchType.LAZY)   // @JoinColumn없이 targetEntity만 매칭시키면 entity의 @Id 변수명을 따라간다. 주의!!!!
    @JoinColumn(name = "team_id")
//    @JoinColumn(name = "team_teamid") // error -> name 공식은 Team entity의 @id를 찾도록 entity_id로 항상 매핑해야하나?
    private Team memberTeam;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = {
            @JoinColumn(name = "MEMBER_ID")
    })
    @Column(name = "FOOD_NAME") // 값 타입 컬렉션이지만 필드가 하나일 때 사용
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns = {
//            @JoinColumn(name = "MEMBER_ID")
//    })
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

}
