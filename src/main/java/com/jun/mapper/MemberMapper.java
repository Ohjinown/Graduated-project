package com.jun.mapper;

import com.jun.dto.MemberDto;

public interface MemberMapper {

    /**
     *
     * @param empNo
     * @return
     */
    MemberDto selectMember(MemberDto member);

    /**
     *
     * @param member
     * @return
     */
    void insertMember(MemberDto member);

    /**
     *
     * @param member
     * @return
     */
    void updateMember(MemberDto member);
}
