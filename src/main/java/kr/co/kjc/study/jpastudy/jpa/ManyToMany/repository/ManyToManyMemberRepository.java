package kr.co.kjc.study.jpastudy.jpa.ManyToMany.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain.ManyToManyMember;
import kr.co.kjc.study.jpastudy.jpa.ManyToMany.domain.ManyToManyTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ManyToManyMemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createMemberAndTeam() {

        ManyToManyTeam team = new ManyToManyTeam();
        team.setName("TeamA");
        em.persist(team);

        ManyToManyMember member = new ManyToManyMember();
        member.setUsername("member1");
        member.changeManyToManyTeam(team);          // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.
                                                       // ManyToManyMember.changeManyToManyTeam 처럼 연관관계 편의 메소드를 지정하면 관리하기 편한다
        em.persist(member);

//        team.setManyToManyMembers().add(member); // 양방향 매핑할 땐 양쪽에다가 값을 세팅하는게 낫다.


        em.flush();
        em.clear();

        ManyToManyMember findMember = em.find(ManyToManyMember.class, member.getId());
        List<ManyToManyMember> members = findMember.getManyToManyTeam().getManyToManyMembers();

        System.out.println("===================================");
        for(ManyToManyMember manyToManyMember : members) {
            System.out.println("manyToManyMember = " + manyToManyMember.getUsername());
        }
        System.out.println("===================================");
    }
}
