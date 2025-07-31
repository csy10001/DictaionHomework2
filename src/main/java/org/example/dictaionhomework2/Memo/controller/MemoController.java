package org.example.dictaionhomework2.Memo.controller;

import lombok.RequiredArgsConstructor;
import org.example.dictaionhomework2.Memo.dto.MemoRequestDto;
import org.example.dictaionhomework2.Memo.dto.MemoResponseDto;
import org.example.dictaionhomework2.Memo.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto memoRequestDto){
        return memoService.createMemo(memoRequestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos(){
        return memoService.getMemos();
    }

    @GetMapping("/memos/{memoId}")
    public MemoResponseDto getMemo(@PathVariable Long memoId){
        return memoService.getMemo(memoId);
    }

    @PutMapping("/memos/{memoId}")
    public MemoResponseDto updateMemo(@PathVariable Long memoId, @RequestBody MemoRequestDto memoRequestDto){
        return memoService.updateMemo(memoId,memoRequestDto);
    }

    @DeleteMapping("/memos/{memosId}")
    public void deleteMemo(@PathVariable Long memosId){
        memoService.deleteMemo(memosId);
    }
}
