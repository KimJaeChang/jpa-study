package kr.co.kjc.study.jpastudy.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    public Member createMember() {

        try {
            transaction.begin();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        em.flush();
        em.close();
        emf.close();

        Member member = new Member();
        return member;
    }

}
