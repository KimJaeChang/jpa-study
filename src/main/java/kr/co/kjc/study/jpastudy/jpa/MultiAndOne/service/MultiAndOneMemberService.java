package kr.co.kjc.study.jpastudy.jpa.MultiAndOne.service;

import kr.co.kjc.study.jpastudy.jpa.MultiAndOne.repository.MultiAndOneMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiAndOneMemberService {

    private final MultiAndOneMemberRepository multiAndOneMemberRepository;

    public void createMemberAndTeam() {
        multiAndOneMemberRepository.createMemberAndTeam();
    }


}
