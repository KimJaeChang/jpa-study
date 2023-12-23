package kr.co.kjc.study.jpastudy.jpa.web.controller;

import kr.co.kjc.study.jpastudy.jpa.embedded.domain.EmbeddedMember;
import kr.co.kjc.study.jpastudy.jpa.embedded.domain.EmbeddedTeam;
import kr.co.kjc.study.jpastudy.jpa.embedded.service.EmbeddedMemberService;
import kr.co.kjc.study.jpastudy.jpa.embedded.service.EmbeddedTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudyController {
    private final EmbeddedMemberService memberService;
    private final EmbeddedTeamService teamService;

    @GetMapping("/member")
    public ResponseEntity<EmbeddedMember> member(@RequestParam String userId){

        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        EmbeddedMember result = memberService.findMember(userId);
        return new ResponseEntity<EmbeddedMember>(result, resHeaders, HttpStatus.OK);
    }

    // URL에서 테스트를 빨리하기위해 일부러 GET으로 했지만 POST가 맞다
    @GetMapping("/create-member")
    public ResponseEntity<EmbeddedMember> createMember(){
        EmbeddedMember result = memberService.createMember();
        return new ResponseEntity<EmbeddedMember>(result, HttpStatus.OK);
    }

    @GetMapping("/create-team")
    public ResponseEntity<EmbeddedTeam> createTeam(){
        EmbeddedTeam result = teamService.createTeam();
        return new ResponseEntity<EmbeddedTeam>(result, HttpStatus.OK);
    }

    @GetMapping("/update-member")
    public ResponseEntity<EmbeddedMember> updateMember(){
        EmbeddedMember result = memberService.updateMemberByTeam();
        return new ResponseEntity<EmbeddedMember>(result, HttpStatus.OK);
    }

    @GetMapping("/create-collection")
    public ResponseEntity<HttpStatus> createCollection(){
        memberService.createCollection();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
