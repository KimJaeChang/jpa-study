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

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager entityManager;

    public Member findMember(String userId) {

        // 분명 Member의 Team은 Lazy인데 왜 team이 select 되어지지?
        Member findMember = entityManager.find(Member.class, userId);
        System.out.println("\t");
        System.out.println("findMember : " + findMember);
        System.out.println("\t");

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
        findMember.setTeam(findTeam);

        entityManager.persist(findMember);
        return null;
    }
}
