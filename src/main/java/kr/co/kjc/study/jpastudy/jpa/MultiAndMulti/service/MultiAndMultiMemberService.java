package kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.service;

import kr.co.kjc.study.jpastudy.jpa.MultiAndMulti.repository.MultiAndMultiMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MultiAndMultiMemberService {

    private final MultiAndMultiMemberRepository multiAndOneMemberRepository;

    public void createMemberAndTeam() {
        multiAndOneMemberRepository.createMemberAndTeam();
    }


}
