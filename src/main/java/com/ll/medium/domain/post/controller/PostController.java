package com.ll.medium.domain.post.controller;

import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.domain.post.dto.PostRequestDto;
import com.ll.medium.domain.post.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //1. 글 작성
    @GetMapping("/post/write")
    public String writeForm(){
        return "글 작성 폼";
    }

    @PostMapping("/post/write")
    public String write(HttpServletRequest request, @RequestBody PostRequestDto postRequestDto) {
        HttpSession session = request.getSession();
        //1. 현재 로그인한 사람의 정보 갖고오기 = 글쓴이
        Member member = (Member)session.getAttribute("Member");
        //2. 로그인한 사용자 정보, 작성한 글 정보를 service에 보내기
        postService.write(postRequestDto, member.getId());
        return "글 작성 완료";
    }
}

