package com.ll.medium.domain.Member.service;

import com.ll.medium.domain.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ll.medium.domain.Member.entity.Member;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void join(String username, String password){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        memberRepository.save(member);
    }

}
