package kr.co.kjc.study.jpastudy.jpa.embedded.service;

import kr.co.kjc.study.jpastudy.jpa.embedded.domain.EmbeddedTeam;
import kr.co.kjc.study.jpastudy.jpa.embedded.repository.EmbeddedTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmbeddedTeamService {

    private final EmbeddedTeamRepository teamRepository;

    public EmbeddedTeam createTeam() {
        return teamRepository.createTeam();
    }
}
