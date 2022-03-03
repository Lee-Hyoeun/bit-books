package kr.books.bitbooks.config;


import kr.books.bitbooks.member.vo.MemberVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProcessInterceptor extends HandlerInterceptorAdapter  {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        boolean result = false;

        try {
            MemberVO member = (MemberVO) request.getSession().getAttribute("userInfo");
            if(member == null ){
                if(isAjaxRequest(request)) {
                    response.sendError(405);
                    return false;
                }else{
                    response.sendRedirect("/login");
                    result =  false;
                }
            }else{
                result =  true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
        return result;
    }

    private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
        if ("true".equals(header)){
            return true;
        }else{
            return false;
        }
    }
}
