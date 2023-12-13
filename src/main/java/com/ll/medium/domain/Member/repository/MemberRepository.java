package com.ll.medium.domain.Member.repository;

import com.ll.medium.domain.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
    Optional<Member> findByUsername(String username);
}
