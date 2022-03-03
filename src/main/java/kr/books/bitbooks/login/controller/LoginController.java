package kr.books.bitbooks.login.controller;

import kr.books.bitbooks.login.service.LoginService;
import kr.books.bitbooks.login.vo.LoginRequest;
import kr.books.bitbooks.member.vo.MemberVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    // 로그인
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/login/login");
        return view;
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> loginUser(@ModelAttribute LoginRequest loginRequest,
                                          HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        int resultCode = 200;
        String resultMsg ="";

        try{
            MemberVO vo = loginService.login(loginRequest);

            if(vo != null) {
                HttpSession session = request.getSession();
                session.setAttribute("userInfo", vo);
                session.setMaxInactiveInterval(60*30); //유효시간 30분
                resultMsg = "OK";

            }else {
                resultCode = 400;
                resultMsg = "아이디 또는 비밀번호가 틀렸습니다.";
            }

        }catch(SQLException e) {
            e.printStackTrace();
            resultCode = 500;
            resultMsg ="비정상 동작으로 인한 오류가 발생하였습니다. 관리자에게 문의하세요.";
        }finally {
            resultMap.put("resultCode", resultCode);
            resultMap.put("resultMsg", resultMsg);
        }
        return resultMap;
    }


    @GetMapping("/logout")
    public ModelAndView logout( HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        try{
            HttpSession session = request.getSession();

            if(  session.getAttribute("userInfo") != null) {
                session.removeAttribute("userInfo");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }


        view.setViewName("redirect:/");
        return view;
    }
}
