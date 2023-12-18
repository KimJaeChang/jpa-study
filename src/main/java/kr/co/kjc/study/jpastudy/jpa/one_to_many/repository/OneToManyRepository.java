package kr.co.kjc.study.jpastudy.jpa.one_to_many.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.one_to_many.domain.OneToManyMember;
import kr.co.kjc.study.jpastudy.jpa.one_to_many.domain.OneToManyTeam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToManyRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        OneToManyMember member = new OneToManyMember();
        member.setUsername("member1");

        em.persist(member);

        OneToManyTeam team = new OneToManyTeam();
        team.setName("teamA");
        team.getMembers().add(member);

        em.persist(team);
    }
}
