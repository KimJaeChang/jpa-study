package kr.co.kjc.study.jpastudy.jpa.ManyToOne.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.ManyToOne.domain.ManyToOneMember;
import kr.co.kjc.study.jpastudy.jpa.ManyToOne.domain.ManyToOneTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        member.setManyToOneTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        ManyToOneMember findMember = em.find(ManyToOneMember.class, member.getId());
        ManyToOneTeam findTeam = findMember.getManyToOneTeam();

        System.out.println("findTeam = " + findTeam.getId());
    }
}
