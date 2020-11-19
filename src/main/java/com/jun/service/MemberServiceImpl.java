package com.jun.service;

import com.jun.dao.MemberDao;
import com.jun.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    /**
     * @desc dddsdssdsdssdsdds
     * @param member 사용자아이디
     * @return
     */
    public MemberDto selectMember(MemberDto member) {
        Map resultMap = new HashMap();
        resultMap.put("empNo","pw");
        MemberDto memberDto = memberDao.selectMember(member);

        return memberDto;
    }


    /**
     *
     * @param member
     * @return
     */
    public Map insertMember(MemberDto member) {
        Map resultMap = new HashMap();
        resultMap.put("empNo", "api_member");
        try {
            memberDao.insertMember(member);
            resultMap.put("result", true);
            resultMap.put("errMsg", "정상적으로 등록되었습니다.");
        }catch (Exception e) {
            resultMap.put("result", false);
            resultMap.put("errMsg", "정보가 등록되지 않았습니다.");
        }
        return resultMap;
    }

    /**
     *
     * @param member
     * @return
     */
    public Map updateMember(MemberDto member) {
        Map resultMap = new HashMap();
        resultMap.put("empNo", "api_member");
        try {
            memberDao.updateMember(member);
            resultMap.put("result", true);
            resultMap.put("errMsg", "정상적으로 업데이트되었습니다.");
        }catch (Exception e) {
            resultMap.put("result", false);
            resultMap.put("errMsg", "정보가 업데이트되지 않았습니다.");
        }
        return resultMap;
    }


}
