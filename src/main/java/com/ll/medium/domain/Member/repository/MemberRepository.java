package com.ll.medium.domain.Member.repository;

import com.ll.medium.domain.Member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
}
