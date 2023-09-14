package kr.co.kjc.study.jpastudy.jpa.repository;

import jakarta.persistence.EntityManager;
import kr.co.kjc.study.jpastudy.jpa.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    
    private final EntityManager entityManager;

    @Transactional
    public Team createTeam() {
        
        Team team = new Team();
        team.setId("everon");
        team.setName("에버온");

        entityManager.persist(team);

        Team findTeam = entityManager.find(Team.class, team.getId());
        return findTeam;
    }
    
}
