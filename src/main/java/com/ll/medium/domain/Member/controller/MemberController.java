package com.ll.medium.domain.Member.controller;

import com.ll.medium.domain.Member.dto.JoinRequestDto;
import com.ll.medium.domain.Member.service.MemberService;
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

    public String login(@RequestBody JoinRequestDto joinRequestDto ) {
        String result = memberService.login(joinRequestDto);
        if (result.equals("true")) {
            return "맞습니다.";
        } else {
            return "틀립니다.";
        }
    }
}