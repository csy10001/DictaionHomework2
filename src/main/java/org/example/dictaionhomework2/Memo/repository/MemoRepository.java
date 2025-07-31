package org.example.dictaionhomework2.Memo.repository;


import org.example.dictaionhomework2.Memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
