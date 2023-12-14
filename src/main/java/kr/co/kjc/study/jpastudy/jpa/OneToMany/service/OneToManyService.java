package kr.co.kjc.study.jpastudy.jpa.OneToMany.service;

import kr.co.kjc.study.jpastudy.jpa.OneToMany.repository.OneToManyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OneToManyService {
    private final OneToManyRepository oneToManyRepository;

    public void createMemberAndTeam() {
        oneToManyRepository.createMemberAndTeam();
    }
}
