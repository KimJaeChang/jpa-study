package kr.co.kjc.study.jpastudy.jpa.embedded.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.embedded.domain.EmbeddedTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class EmbeddedTeamRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public EmbeddedTeam createTeam() {
        
        EmbeddedTeam team = new EmbeddedTeam();
        team.setTeamId("everon");
        team.setName("에버온");

        em.persist(team);

        EmbeddedTeam findTeam = em.find(EmbeddedTeam.class, team.getTeamId());
        return findTeam;
    }
    
}
