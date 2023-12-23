package kr.co.kjc.study.jpastudy.jpa.embedded.service;

import kr.co.kjc.study.jpastudy.jpa.embedded.domain.EmbeddedMember;
import kr.co.kjc.study.jpastudy.jpa.embedded.repository.EmbeddedMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmbeddedMemberService {

    private final EmbeddedMemberRepository memberRepository;

    public EmbeddedMember findMember(String userId) {
        return memberRepository.findMember(userId);
    }

    public EmbeddedMember createMember() {
        return memberRepository.createMember();
    }

    public EmbeddedMember updateMemberByTeam() {
        return memberRepository.updateMemberByTeam();
    }

    public void createCollection() {
        memberRepository.createCollection();
    }
}
