package kr.co.kjc.study.jpastudy.jpa.many_to_many.disadvantage.service;

import kr.co.kjc.study.jpastudy.jpa.many_to_many.disadvantage.repository.ManyToManyBeforeMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManyToManyBeforeMemberService {

    private final ManyToManyBeforeMemberRepository manyToManyMemberRepository;

    public void createMemberAndTeam() {
        manyToManyMemberRepository.createMemberAndTeam();
    }


}
