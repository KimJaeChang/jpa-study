package kr.co.kjc.study.jpastudy.jpql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import kr.co.kjc.study.jpastudy.jpql.domain.JpqlMember;
import kr.co.kjc.study.jpastudy.jpql.domain.JpqlTeam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FetchRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public void notFetchJoin() {
    JpqlTeam teamA = new JpqlTeam();
    teamA.setName("Team A");

    JpqlTeam teamB = new JpqlTeam();
    teamB.setName("Team B");

    em.persist(teamA);
    em.persist(teamB);

    JpqlMember memberA = new JpqlMember();
    memberA.setUsername("member A");
    memberA.setJpqlTeam(teamA);

    JpqlMember memberB = new JpqlMember();
    memberB.setUsername("member B");
    memberB.setJpqlTeam(teamA);

    JpqlMember memberC = new JpqlMember();
    memberC.setUsername("member C");
    memberC.setJpqlTeam(teamB);

    em.persist(memberA);
    em.persist(memberB);
    em.persist(memberC);

    em.flush();
    em.clear();

    List<JpqlMember> resultList = em.createQuery("select m From JpqlMember m",
            JpqlMember.class)
        .getResultList();

    // TeamA 와 Team B 를 조회할 때 쿼리가 2번 날라간다. (N+1) 빌셍
    // 1. memberA 조회시 teamA 쿼리로 조회
    // 2. memberB 조회시 teamA 1차캐시(영속성 컨텍스트)에서 불러오기
    // 3. memberC 조회시 teamB 쿼리로 조회
    for (JpqlMember member : resultList) {
      System.out.println("\t");
      System.out.println("member_name : " + member.getUsername());
      System.out.println("\t");
      System.out.println("member_team_name : " + member.getJpqlTeam().getName());
      System.out.println("\t");
    }

  }

  @Transactional
  public void fetchJoin() {

    JpqlTeam teamA = new JpqlTeam();
    teamA.setName("Team A");

    JpqlTeam teamB = new JpqlTeam();
    teamB.setName("Team B");

    em.persist(teamA);
    em.persist(teamB);

    JpqlMember memberA = new JpqlMember();
    memberA.setUsername("member A");
    memberA.setJpqlTeam(teamA);

    JpqlMember memberB = new JpqlMember();
    memberB.setUsername("member B");
    memberB.setJpqlTeam(teamA);

    JpqlMember memberC = new JpqlMember();
    memberC.setUsername("member C");
    memberC.setJpqlTeam(teamB);

    em.persist(memberA);
    em.persist(memberB);
    em.persist(memberC);

    em.flush();
    em.clear();

    List<JpqlMember> resultList = em.createQuery("select m From JpqlMember m join fetch m.jpqlTeam",
            JpqlMember.class)
        .getResultList();

    for (JpqlMember member : resultList) {
      System.out.println("member : " + member.getUsername() + ", " + member.getJpqlTeam().getName());
    }

  }
}
