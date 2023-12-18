package kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.service;

import kr.co.kjc.study.jpastudy.jpa.ManyToMany.disadvantage.repository.ManyToManyBeforeMemberRepository;
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
