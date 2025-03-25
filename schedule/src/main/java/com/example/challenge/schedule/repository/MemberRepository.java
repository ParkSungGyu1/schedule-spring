package com.example.challenge.schedule.repository;

import com.example.challenge.schedule.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByEmailAndPassword(String email, String password);
    Optional<Member> findById(Long id);
    boolean existByEmail(String email);
    Member update(Long id, Member member);
    void deleteById(Long id);
}
