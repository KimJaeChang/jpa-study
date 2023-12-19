package kr.co.kjc.study.jpastudy.jpa.proxy.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.proxy.domain.ProxyMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProxyRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void compareEntity() {

        ProxyMember member1 = new ProxyMember();
        member1.setUsername("username1");
        em.persist(member1);

        ProxyMember member2 = new ProxyMember();
        member2.setUsername("username1");
        em.persist(member2);

        em.flush();
        em.clear();

        ProxyMember findMember1 = em.find(ProxyMember.class, member1.getProxyMemberId());
        ProxyMember findMember2 = em.find(ProxyMember.class, member2.getProxyMemberId());

        System.out.println("findMember1 == findMember2 : " + (findMember1.getClass() == findMember2.getClass()));

    }

    @Transactional
    public void compareRefernceTrue() {

        ProxyMember member1 = new ProxyMember();
        member1.setUsername("username1");
        em.persist(member1);

        ProxyMember member2 = new ProxyMember();
        member2.setUsername("username1");
        em.persist(member2);

        em.flush();
        em.clear();

        ProxyMember findMember1 = em.find(ProxyMember.class, member1.getProxyMemberId());
        ProxyMember findMember2 = em.getReference(ProxyMember.class, member2.getProxyMemberId());

        System.out.println("findMember1 instanceof ProxyMember : " + (findMember1 instanceof ProxyMember));
        System.out.println("findMember2 instanceof ProxyMember : " + (findMember2 instanceof ProxyMember));

    }


    @Transactional
    public void compareRefernceFalse() {

        ProxyMember member1 = new ProxyMember();
        member1.setUsername("username1");
        em.persist(member1);

        ProxyMember member2 = new ProxyMember();
        member2.setUsername("username1");
        em.persist(member2);

        em.flush();
        em.clear();

        ProxyMember findMember1 = em.find(ProxyMember.class, member1.getProxyMemberId());
        ProxyMember findMember2 = em.getReference(ProxyMember.class, member2.getProxyMemberId());

        System.out.println("findMember1 == findMember2 : " + (findMember1.getClass() == findMember2.getClass()));

    }
}
