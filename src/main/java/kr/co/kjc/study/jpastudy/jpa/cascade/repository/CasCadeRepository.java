package kr.co.kjc.study.jpastudy.jpa.cascade.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.cascade.domain.CasCadeChild;
import kr.co.kjc.study.jpastudy.jpa.cascade.domain.CasCadeParent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CasCadeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {

        CasCadeChild child1 = new CasCadeChild();
        CasCadeChild child2 = new CasCadeChild();

        CasCadeParent parent = new CasCadeParent();
        parent.addChild(child1);
        parent.addChild(child2);

        em.persist(parent);
//        em.persist(child1);   // CasCadeParent 에 CasCade가 잡혀있어서 child를 persist를 안해도 같이 insert가 된다.
//        em.persist(child2);

        em.flush();
        em.clear();

        CasCadeParent findParent = em.find(CasCadeParent.class, parent.getId());
        findParent.getChilds().remove(0);

    }
}
