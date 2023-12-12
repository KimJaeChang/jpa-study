package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain.MultiAndMultiMember;
import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.domain.MultiAndMultiTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MultiAndMultiMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        MultiAndMultiTeam team = new MultiAndMultiTeam();
        team.setName("TeamA");
        em.persist(team);

        MultiAndMultiMember member = new MultiAndMultiMember();
        member.setUsername("member1");
        member.setMultiAndMultiTeam(team);
        em.persist(member);

        em.flush();
        em.clear();

        MultiAndMultiMember findMember = em.find(MultiAndMultiMember.class, member.getId());
        List<MultiAndMultiMember> members = findMember.getMultiAndMultiTeam().getMultiAndMultiMembers();

        for(MultiAndMultiMember multiAndMultiMember : members) {
            System.out.println("multiAndMultiMember = " + multiAndMultiMember.getUsername());
        }
    }
}
