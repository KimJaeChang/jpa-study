package kr.co.kjc.study.jpastudy.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.kjc.study.jpastudy.jpa.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Team createTeam() {
        
        Team team = new Team();
        team.setTeamId("everon");
        team.setName("에버온");

        em.persist(team);

        Team findTeam = em.find(Team.class, team.getTeamId());
        return findTeam;
    }
    
}
