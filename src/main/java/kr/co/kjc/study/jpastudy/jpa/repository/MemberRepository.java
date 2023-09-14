package kr.co.kjc.study.jpastudy.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import kr.co.kjc.study.jpastudy.jpa.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager entityManager;

    @Transactional
    public Member findMember(String userId) {

        // 1. 분명 Member의 Team은 Lazy인데 왜 team이 select 되어지지?
        // 2. 아하 Team의 oneToMany를 지정 안 해주면 Lazy로딩이 적용되지 않는다.!!!
        // 3. ToString을 쓰면 lazy로딩이 적용되지 않는다.
        Member findMember = entityManager.find(Member.class, userId);
        System.out.println("\t");
        System.out.println("findMember.id : " + findMember.getId());
        System.out.println("findMember.name : " + findMember.getName());

        // lazy 로딩일 때 해당 컬럼을 조회하면 sql 쿼리가 실행된다.
        System.out.println("\t");
//        System.out.println("findMember.memberTeam : " + findMember.getMemberTeam());
        System.out.println("findMember.memberTeam.teamid : " + findMember.getMemberTeam().getTeamId());
        System.out.println("findMember.memberTeam.name : " + findMember.getMemberTeam().getName());
        System.out.println("\t");

        try {
            // lazy 로딩이라도 프록시 객체의 존재로 인해 null이 아님
            boolean isNotnull = findMember.getClass().getDeclaredField("memberTeam") != null;
            System.out.println("\t");
            System.out.println("isNotnull : " + isNotnull);
            System.out.println("\t");
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Team findTeam = entityManager.find(Team.class, findMember.getMemberTeam().getTeamId());
//
//        System.out.println("\t");
//        System.out.println("findTeam.id : " + findTeam.getTeamId());
//        System.out.println("findTeam.name : " + findTeam.getName());
//        System.out.println("findTeam.members : " + findTeam.getMembers());
//        System.out.println("\t");

        return null;
    }

    @Transactional
    public Member createMember() {

//        EntityTransaction transaction = entityManager.getTransaction();

        try {
//            transaction.begin();

            Member kjc = new Member();
            kjc.setId("kjc");
            kjc.setName("김재창");
            entityManager.persist(kjc);

            Member jjw = new Member();
            jjw.setId("jjw");
            jjw.setName("정지운");
            entityManager.persist(jjw);

            Member findKjc = entityManager.find(Member.class, kjc.getId());
            Member findJjw = entityManager.find(Member.class, jjw.getId());

            System.out.println("\t");
            System.out.println("findKjc : " + findKjc);
            System.out.println("\t");
            System.out.println("findJjw : " + findJjw);
            System.out.println("\t");


//            transaction.commit();
        } catch (Exception e) {
//            transaction.rollback();
        } finally {
            entityManager.close();
        }

        return null;
    }

    @Transactional
    public Member updateMemberByTeam() {
        Team findTeam = entityManager.find(Team.class, "everon");
        Member findMember = entityManager.find(Member.class, "kjc");
        findMember.setMemberTeam(findTeam);

        entityManager.persist(findMember);
        return null;
    }
}
