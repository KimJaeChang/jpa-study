package kr.co.kjc.study.jpastudy.jpa.many_to_many.overcome.service;

import kr.co.kjc.study.jpastudy.jpa.many_to_many.overcome.repository.ManyToManyMemberRepository;
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
