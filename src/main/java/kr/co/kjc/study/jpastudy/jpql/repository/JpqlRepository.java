package kr.co.kjc.study.jpastudy.jpql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import kr.co.kjc.study.jpastudy.jpql.domain.JpqlMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JpqlRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMember() {

        JpqlMember member = new JpqlMember();
        member.setUsername("member1");
        member.setAge(10);

        em.persist(member);
        em.flush();
        em.clear();

        TypedQuery<JpqlMember> typedQueryMember = em.createQuery("select m from JpqlMember m where m.username = :username", JpqlMember.class);
        List<JpqlMember> typeQueryMemberResult = typedQueryMember
                .setParameter("username", member.getUsername())
                .getResultList();
        System.out.println("typeQueryMemberResult : " + typeQueryMemberResult);

        Query queryJpqlMember = em.createQuery("select m from JpqlMember m where m.username = :username");
        List queryJpqlMemberResult = queryJpqlMember
                .setParameter("username", member.getUsername())
                .getResultList();
        System.out.println("queryJpqlMemberResult : " + queryJpqlMemberResult);

        System.out.println("boolean : " + (typeQueryMemberResult.get(0) instanceof JpqlMember));
        System.out.println("boolean : " + (queryJpqlMemberResult.get(0) instanceof JpqlMember));


    }
}
