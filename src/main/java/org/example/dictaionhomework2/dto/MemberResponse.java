package org.example.dictaionhomework2.dto;

import lombok.Getter;

@Getter
public class MemberResponse {
    private Long id;
    private String name;

    public MemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
