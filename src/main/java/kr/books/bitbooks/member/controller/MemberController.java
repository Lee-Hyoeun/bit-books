package kr.books.bitbooks.member.controller;


import kr.books.bitbooks.member.service.MemberService;
import kr.books.bitbooks.member.vo.MemberRequest;
import kr.books.bitbooks.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/user/register")
    public ModelAndView signUpView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/user/signup");
        return view;
    }

    @GetMapping("/user/checkId")
    @ResponseBody
    public Map<String, Object> checkMemeber(@RequestParam(value="userId") String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        try{

            Map<String, Object> param = new HashMap<>();
            param.put("userId", userId);
            MemberVO vo = memberService.getMember(param);

            if(vo != null) {
                resultMap.put("duplicated", true);

            }else {
                resultMap.put("duplicated", false);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    @PostMapping("/user/signup")
    @ResponseBody
    public Map<String, Object> signup(@ModelAttribute MemberRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        try{

            int result = memberService.userSignUp(request);

            if(result > 0) {
                resultMap.put("resultCode", 200);
            }else {
                resultMap.put("resultCode", 400);
                resultMap.put("resultMsg","insert Fail");
            }

        }catch (Exception e) {
            e.printStackTrace();
            resultMap.put("resultCode", 400);
            resultMap.put("resultMsg", e.getMessage());
        }

        return resultMap;
    }

}
