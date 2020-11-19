package com.jun.service;

import com.jun.dto.MemberDto;

import java.util.Map;

public interface MemberService {

    //회원조회
    public MemberDto selectMember(MemberDto member);

    //회원등록
    public Map insertMember(MemberDto member);

    //회원수정
    public Map updateMember(MemberDto member);


}

