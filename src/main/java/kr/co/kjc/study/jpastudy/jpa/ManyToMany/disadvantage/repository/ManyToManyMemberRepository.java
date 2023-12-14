package kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.domain.ManyToManyBeforeMember;
import kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.domain.ManyToManyTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ManyToManyMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        ManyToManyTeam team = new ManyToManyTeam();
        team.setName("TeamA");
        em.persist(team);

        ManyToManyBeforeMember member = new ManyToManyBeforeMember();
        member.setUsername("member1");

        em.persist(member);

        em.flush();
        em.clear();


    }
}
