package org.example.dictaionhomework2.Memo.service;

import lombok.RequiredArgsConstructor;
import org.example.dictaionhomework2.Memo.dto.MemoRequestDto;
import org.example.dictaionhomework2.Memo.dto.MemoResponseDto;
import org.example.dictaionhomework2.Memo.entity.Memo;
import org.example.dictaionhomework2.Memo.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto createMemo(MemoRequestDto memoRequestDto) {
        Memo memo = new Memo(memoRequestDto.getName());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoResponseDto(savedMemo.getId(), savedMemo.getName()
        );
    }

    @Transactional(readOnly = true)
    public MemoResponseDto getMemo(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 멤버 id가 없습니다.")
        );

        return new MemoResponseDto(memo.getId(), memo.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> getMemos() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            MemoResponseDto memoResponseDto = new MemoResponseDto(memo.getId(), memo.getName()
            );
            dtos.add(memoResponseDto);
        }
        return dtos;
    }

    @Transactional
    public MemoResponseDto updateMemo(Long id, MemoRequestDto memoRequestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 멤버 id가 없습니다.")
        );
        memo.updateName(memoRequestDto.getName());
        return new MemoResponseDto(memo.getId(), memo.getName()
        );
    }

    @Transactional
    public void deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 멤버 id가 없습니다.")
        );
        memoRepository.deleteById(id);
    }
}
