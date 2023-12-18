package kr.co.kjc.study.jpastudy.jpa.many_to_one.service;

import kr.co.kjc.study.jpastudy.jpa.many_to_one.repository.ManyToOneMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManyToOneMemberService {

    private final ManyToOneMemberRepository manyToOneMemberRepository;

    public void createMemberAndTeam() {
        manyToOneMemberRepository.createMemberAndTeam();
    }


}
