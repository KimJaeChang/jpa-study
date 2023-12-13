package kr.co.kjc.study.jpastudy.jpa.ManyToMany.service;

import kr.co.kjc.study.jpastudy.jpa.ManyToMany.repository.ManyToManyMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManyToManyMemberService {

    private final ManyToManyMemberRepository manyToManyMemberRepository;

    public void createMemberAndTeam() {
        manyToManyMemberRepository.createMemberAndTeam();
    }


}
