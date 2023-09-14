package kr.co.kjc.study.jpastudy.jpa.service;

import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import kr.co.kjc.study.jpastudy.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(String userId) {
        return memberRepository.findMember(userId);
    }

    public Member createMember() {
        return memberRepository.createMember();
    }

    public Member updateMemberByTeam() {
        return memberRepository.updateMemberByTeam();
    }
}
