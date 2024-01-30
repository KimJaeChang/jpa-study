package kr.co.kjc.study.jpastudy.jpa.many_to_one.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.many_to_one.domain.ManyToOneMember;
import kr.co.kjc.study.jpastudy.jpa.many_to_one.domain.ManyToOneTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ManyToOneMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        ManyToOneTeam team = new ManyToOneTeam();
        team.setName("TeamA");
        em.persist(team);

        ManyToOneMember member = new ManyToOneMember();
        member.setUsername("member1");
        member.changeManyToOneTeam(team);          // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.
        // ManyToManyMember.changeManyToOneTeam 처럼 연관관계 편의 메소드를 지정하면 관리하기 편한다
        em.persist(member);

//        team.setManyToManyMembers().add(member); // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.;
        em.persist(member);

        em.flush();
        em.clear();

        ManyToOneMember findMember = em.find(ManyToOneMember.class, member.getManyToOneMemberId());
        List<ManyToOneMember> members = findMember.getManyToOneTeam().getManyToOneMembers();

        System.out.println("===================================");
        for(ManyToOneMember manyToOneMember : members) {
            System.out.println("manyToOneMember = " + manyToOneMember.getUsername());
        }
        System.out.println("===================================");

    }
}
