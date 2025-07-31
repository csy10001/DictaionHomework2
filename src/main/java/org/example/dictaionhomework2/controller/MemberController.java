package org.example.dictaionhomework2.controller;

import lombok.RequiredArgsConstructor;
import org.example.dictaionhomework2.dto.MemberRequest;
import org.example.dictaionhomework2.dto.MemberResponse;
import org.example.dictaionhomework2.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public MemberResponse createMember(
            @RequestBody MemberRequest memberRequest){
        return memberService.save(memberRequest);
    }

    @GetMapping("/members")
    public List<MemberResponse> getMembers(){
        return memberService.findMembers();
    }

    @GetMapping("/members/{memberId}")
    public MemberResponse getMember(
            @PathVariable Long memberId){
        return memberService.findMembe(memberId);
    }

    @PutMapping("/members/{memberId}")
    public MemberResponse updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberRequest memberRequest){
        return memberService.update(memberId,memberRequest);
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(
            @PathVariable Long memberId){
        memberService.deleteMember(memberId);
    }
}
