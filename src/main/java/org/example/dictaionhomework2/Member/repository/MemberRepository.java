package org.example.dictaionhomework2.Member.repository;

import org.example.dictaionhomework2.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
