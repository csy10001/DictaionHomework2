package org.example.dictaionhomework2.repository;

import org.example.dictaionhomework2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
