package kr.co.kjc.study.jpastudy.jpa.service;

import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    public Member createMember() {
        Member member = new Member();
        return member;
    }
}
