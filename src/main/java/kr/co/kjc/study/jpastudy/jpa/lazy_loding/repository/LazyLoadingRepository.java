package kr.co.kjc.study.jpastudy.jpa.lazy_loding.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.lazy_loding.domain.LazyLoadingMember;
import kr.co.kjc.study.jpastudy.jpa.lazy_loding.domain.LazyLoadingTeam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LazyLoadingRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {

        LazyLoadingTeam team = new LazyLoadingTeam();
        team.setName("teamA");

        em.persist(team);

        LazyLoadingMember member = new LazyLoadingMember();
        member.setUsername("member1");

        em.persist(member);

        em.flush();
        em.clear();

        LazyLoadingMember findMember = em.find(LazyLoadingMember.class, member.getId());

        System.out.println("===================================");

        findMember.getUsername();   // 프록시 초기화

        System.out.println("===================================");
    }
}
