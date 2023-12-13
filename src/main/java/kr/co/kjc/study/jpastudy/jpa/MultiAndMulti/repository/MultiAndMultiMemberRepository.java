package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain.MultiAndMultiMember;
import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain.MultiAndMultiTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MultiAndMultiMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        MultiAndMultiTeam team = new MultiAndMultiTeam();
        team.setName("TeamA");
        em.persist(team);

        MultiAndMultiMember member = new MultiAndMultiMember();
        member.setUsername("member1");
        member.changeMultiAndMultiTeam(team);          // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.
                                                       // MultiAndMultiMember.changeMultiAndMultiTeam 처럼 연관관계 편의 메소드를 지정하면 관리하기 편한다
        em.persist(member);

//        team.getMultiAndMultiMembers().add(member); // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.


        em.flush();
        em.clear();

        MultiAndMultiMember findMember = em.find(MultiAndMultiMember.class, member.getId());
        List<MultiAndMultiMember> members = findMember.getMultiAndMultiTeam().getMultiAndMultiMembers();

        System.out.println("===================================");
        for(MultiAndMultiMember multiAndMultiMember : members) {
            System.out.println("multiAndMultiMember = " + multiAndMultiMember.getUsername());
        }
        System.out.println("===================================");
    }
}
