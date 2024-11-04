package kr.co.kjc.study.jpastudy.jpa.one_to_one.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneLocker;
import kr.co.kjc.study.jpastudy.jpa.one_to_one.domain.OneToOneMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToOneRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public void create() {

    OneToOneLocker ol = new OneToOneLocker();
    ol.setName("카드1");

    em.persist(ol);

    OneToOneMember om = new OneToOneMember();
    om.setUsername("회원1");
    om.setOneToOneLocker(ol);

    em.persist(om);

  };

}
