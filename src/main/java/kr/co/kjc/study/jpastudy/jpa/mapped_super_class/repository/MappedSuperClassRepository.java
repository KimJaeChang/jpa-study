package kr.co.kjc.study.jpastudy.jpa.mapped_super_class.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.mapped_super_class.domain.MappedSuperClassMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class MappedSuperClassRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create() {
        MappedSuperClassMember member = new MappedSuperClassMember();
        member.setUsername("user1");
        member.setCreatedBy("kim");
        member.setCreatedDate(LocalDateTime.now());

        em.persist(member);

        em.flush();
        em.clear();
    }
}
