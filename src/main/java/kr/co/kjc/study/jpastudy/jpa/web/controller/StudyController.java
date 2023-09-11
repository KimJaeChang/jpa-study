package kr.co.kjc.study.jpastudy.jpa.web.controller;

import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import kr.co.kjc.study.jpastudy.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {
    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<Member> createMember(){
        Member result = memberService.createMember();
        return new ResponseEntity<Member>(result, HttpStatus.OK);
    }


}
