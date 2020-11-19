package com.jun.dao;

import com.jun.dto.MemberDto;
import com.jun.mapper.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
    public class MemberDao {

        @Autowired
        private SqlSession sqlSession;
        /**
         *
         * @param member
         * @return
         */
        public MemberDto selectMember(final MemberDto member) {

            MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

            MemberDto memberDto = mapper.selectMember(member);

            return memberDto;
        }
        /**
         *
         * @param member
         * @return
         */
        public void insertMember(final MemberDto member) {
            MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
            mapper.insertMember(member);
            //return memberDto;
        }

    /**
     *
     * @param member
     * @return
     */
    public void updateMember(final MemberDto member) {
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        mapper.updateMember(member);
       // return memberDto;
    }
    }

