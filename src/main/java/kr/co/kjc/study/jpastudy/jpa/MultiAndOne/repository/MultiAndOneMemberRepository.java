package kr.co.kjc.study.jpastudy.jpa.MultiAndOne.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.MultiAndOne.domain.MultiAndOneMember;
import kr.co.kjc.study.jpastudy.jpa.MultiAndOne.domain.MultiAndOneTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MultiAndOneMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        MultiAndOneTeam team = new MultiAndOneTeam();
        team.setName("TeamA");
        em.persist(team);

        MultiAndOneMember member = new MultiAndOneMember();
        member.setUsername("member1");
        member.setMultiAndOneTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        MultiAndOneMember findMember = em.find(MultiAndOneMember.class, member.getId());
        MultiAndOneTeam findTeam = findMember.getMultiAndOneTeam();

        System.out.println("findTeam = " + findTeam.getId());
    }
}
