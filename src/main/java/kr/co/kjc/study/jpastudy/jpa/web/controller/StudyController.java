package kr.co.kjc.study.jpastudy.jpa.web.controller;

import kr.co.kjc.study.jpastudy.jpa.domain.Member;
import kr.co.kjc.study.jpastudy.jpa.domain.Team;
import kr.co.kjc.study.jpastudy.jpa.service.MemberService;
import kr.co.kjc.study.jpastudy.jpa.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {
    private final MemberService memberService;
    private final TeamService teamService;

    @GetMapping("/member")
    public ResponseEntity<Member> member(@RequestParam String userId){

        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        Member result = memberService.findMember(userId);
        return new ResponseEntity<Member>(result, resHeaders, HttpStatus.OK);
    }

    // URL에서 테스트를 빨리하기위해 일부러 GET으로 했지만 POST가 맞다
    @GetMapping("/create-member")
    public ResponseEntity<Member> createMember(){
        Member result = memberService.createMember();
        return new ResponseEntity<Member>(result, HttpStatus.OK);
    }

    @GetMapping("/create-team")
    public ResponseEntity<Team> createTeam(){
        Team result = teamService.createTeam();
        return new ResponseEntity<Team>(result, HttpStatus.OK);
    }

    @GetMapping("/update-member")
    public ResponseEntity<Member> updateMember(){
        Member result = memberService.updateMemberByTeam();
        return new ResponseEntity<Member>(result, HttpStatus.OK);
    }

    @GetMapping("/create-collection")
    public ResponseEntity<HttpStatus> createCollection(){
        memberService.createCollection();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
