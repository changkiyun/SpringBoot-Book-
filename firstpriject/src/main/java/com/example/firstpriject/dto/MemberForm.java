package com.example.firstpriject.dto;

import com.example.firstpriject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    //Member
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(null, email, password);
    }
}
