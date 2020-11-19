package com.jun.controller;

import com.jun.dto.MemberDto;
import com.jun.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/mbr")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @RequestMapping("/home")
    public String home(ModelAndView mav){
        return "main";
    }
//회원 정보 조회
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    @ResponseBody
    public Map getMember(MemberDto member){
        logger.info("called getMember.");
        Map resultMap = new HashMap();
        MemberDto memberDto = memberService.selectMember(member);
        resultMap.put("success", true);
        resultMap.put("result", memberDto);
        return resultMap;
    }
    @RequestMapping(value = "/change", method = RequestMethod.PUT)
    public Map change(MemberDto member, HttpServletRequest request){
        //회원정보 수정
        //1.비밀번호만 수정하게 한다
        //2.비밀번호 수정후 업데이트해 적용 시킨다.
        // 그럼 수정이 되면 true 안되면 false pw값이
        //memberDto에 안드로이드 pw 값이 들어가야한다. pw값이 들어가면 성공 안들어가면 실패


        return memberService.updateMember(member);
    }

        //회원정보 수정
        //1.비밀번호만 수정하게 한다
        //2.비밀번호 수정후 업데이트해 적용 시킨다.
        // 그럼 수정이 되면 true 안되면 false pw값이
        //memberDto에 안드로이드 pw 값이 들어가야한다. pw값이 들어가면 성공 안들어가면 실패


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(MemberDto member, HttpServletRequest request) {
        //1.DB에 요청한 아이디 비밀번호 값이 똑같은게 있는지 확인
        MemberDto memberDto = memberService.selectMember(member);
        //2.요청한 값이 같은게 있으면 아이디 비밀번호 값을 가져와 로그인 한다.
        Map resultMap = new HashMap();//memberDto가 null로 가져 왔기 때문에 다른값을 대입하면 안된다.
        if (memberDto != null){
            resultMap.put("success",true);
            resultMap.put("result", memberDto);
        } else {
            resultMap.put("success",false);
        }
        return resultMap;
    }


    @RequestMapping(value = "/member", method = RequestMethod.POST)//회원가입 POST
    public Map setMember(MemberDto member, HttpServletRequest request) {
        return memberService.insertMember(member);
    }


    @RequestMapping("/index")
    public String index(){

        return "/WEB-INF/index.jsp";
    }

    @RequestMapping("/login")
    public String loginForm(){

        return "loginForm";
    }
//    //해당 url/id 값으로 요청이 들어오면 loginResultView 메소드 실행
//    @RequestMapping("/loginResultView/{id}")
//    public String loginTestResult(@PathVariable String id, Model model){
//
//
//        MemberDto dto = memberService.selectMember(id);
//
//        model.addAttribute("member", dto);
//
//        return "loginResultView";
//    }
}
