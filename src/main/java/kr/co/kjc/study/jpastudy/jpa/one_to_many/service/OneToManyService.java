package kr.co.kjc.study.jpastudy.jpa.one_to_many.service;

import kr.co.kjc.study.jpastudy.jpa.one_to_many.repository.OneToManyRepository;
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
