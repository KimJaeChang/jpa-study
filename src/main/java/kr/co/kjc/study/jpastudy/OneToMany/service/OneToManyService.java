package kr.co.kjc.study.jpastudy.OneToMany.service;

import kr.co.kjc.study.jpastudy.OneToMany.repository.OneToManyRepository;
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
