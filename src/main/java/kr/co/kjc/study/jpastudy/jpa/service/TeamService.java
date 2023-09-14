package kr.co.kjc.study.jpastudy.jpa.service;

import kr.co.kjc.study.jpastudy.jpa.domain.Team;
import kr.co.kjc.study.jpastudy.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team createTeam() {
        return teamRepository.createTeam();
    }
}
