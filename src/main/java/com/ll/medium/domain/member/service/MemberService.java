package com.ll.medium.domain.member.service;

import com.ll.medium.domain.member.dto.JoinRequestDto;
import com.ll.medium.domain.member.entity.Member;
import com.ll.medium.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Member login(JoinRequestDto joinRequestDto) {
        //정보가 맞는지 확인
        //1. DB로부터 해당 username을 갖고 있는 회원 데이터
        Optional<Member> member = memberRepository.findByUsername(joinRequestDto.getUsername());
        //2. DB로부터 받아온 객체가 null인지 아닌지 확인
        if(member.isEmpty()) {
            return null;
        } else {
            //가져온 회원 데이터의 비밀번호와 클라이언트로부터 온 비밀번호를 비교
            Member memberData = member.get();
            String memberDBPassword = memberData.getPassword();
            String memberClientPassword = joinRequestDto.getPassword();
            //비교해서 맞으면 true 틀리면 false 반환
            if(memberDBPassword.equals(memberClientPassword)) {
                return memberData;
            } else {
                return null;
                }
            }
        }
    }
