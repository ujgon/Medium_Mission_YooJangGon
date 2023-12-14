package com.ll.medium.domain.member.controller;

import com.ll.medium.domain.member.dto.JoinRequestDto;
import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.domain.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/join")
    public String joinForm() {
        return "회원가입 폼";
    }

    @PostMapping("/member/join")
    public String join(@RequestBody JoinRequestDto joinRequestDto) {
        System.out.println("request body" + joinRequestDto.getUsername() + joinRequestDto.getPassword());
        memberService.join(joinRequestDto.getUsername(), joinRequestDto.getPassword());
        return "회원가입이 성공했습니다.";
    }

    @PostMapping("/member/login")
    public String login(HttpServletRequest request, @RequestBody JoinRequestDto joinRequestDto ) {
        Member result = memberService.login(joinRequestDto);
        //서비스에서 로그인이 성공하면 member 보내주고 실패하면 null 보내준다.
        if(result == null) {
            return "틀립니다.";
        }
        //로그인 성공하면 Session에 사용자 정보를 넣어야함
        //1. request로부터 가져온다.
        HttpSession session = request.getSession();
        //2. session에 member 정보 저장
        session.setAttribute("Member", result);
        return "맞습니다.";
    }

    @PostMapping("/member/logout")
    public String logout(HttpServletRequest request) {
        //1. 현재 session이 있는지 없는지 확인
        HttpSession session = request.getSession(false);
        //2. session이 있다면 session 삭제
        if(session != null){
            session.invalidate();
            return "로그아웃 했습니다.";
        }
        return "로그아웃 실패";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "로그인 폼";
    }
}