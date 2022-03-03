package kr.books.bitbooks.notice.controller;

import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.member.vo.MemberVO;
import kr.books.bitbooks.notice.service.NoticeService;
import kr.books.bitbooks.notice.vo.NoticeRequest;
import kr.books.bitbooks.notice.vo.NoticeVO;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class NoticeController {
/*
 * 의존성 주입 방법
 * 1. 주입대상 상단에 @Autowired 어노테이션을 달아준다.
 *   - 단점 : null 처리가 되지 않아서, 실제 주입이 이루어지지 않으면, 오류로 인해 프로그램이 작동안함.
 *   
 * 2. setter 를 통한 주입
 *   - @Autowried 어노테이션을 settr 위에 달아준다.
 *   - 단점 느려요
 *   
 * 3.  생성자를 통한 주입 
 *   - 추천!
 *   
 */
    private final NoticeService service;

    // 공지사항 목록
    @GetMapping("/qa/noticelist")
    public ModelAndView notice(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
    	
        
    	ModelAndView view = new ModelAndView();
        
        view.setViewName("views/notice/adminNoticeboard");

        try {
        	
        	//페이징 처리 객체 선언 
        	PagingVO pagingVO = new PagingVO();

        	//운영자 게시판 게시물 총 개수 
            int totalCount = service.getNoticeCount();

           // 전체 개수 넣어준다 
            pagingVO.setTotalCount(totalCount);
            // 현재 페이지 넣어준다 
            pagingVO.setCurrentPage(currentPage);

            //페이지 범위내에서 출력될 게시판 목록 리스트 가져오기 
            List<NoticeVO> noticeList = service.getNoticeList(pagingVO);
            
            //view 를 호출할때 넘겨줄 데이터  정의 
            view.addObject("currentPage", currentPage);
            view.addObject("paging", pagingVO);
            view.addObject("totalCount", totalCount);
            view.addObject("dataList", noticeList);
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }


        return view;
    }


    @GetMapping("/qa/noticeDetail")
    public ModelAndView noticeDetail(@RequestParam(value="noticeNo") Integer noticeNo) {
        ModelAndView view = new ModelAndView();
        Map<String, Object> param = new HashMap<>();
        try{

            param.put("noticeNo", noticeNo);
            NoticeVO vo = service.selectNoticeDetail(param);
            view.addObject("notice", vo);

        }catch(Exception e) {
            e.printStackTrace();
        }


        view.setViewName("views/notice/adminDetailNotice");
        return view;
    }


    @GetMapping("/qa/noticewrite")
    public ModelAndView noticeWrite() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/notice/adminWriteNotice");
        return view;
    }


    @PostMapping("/qa/notice/write")
    @ResponseBody
    public  Map<String, Object> intsertNotice(@ModelAttribute NoticeRequest request,
                                              HttpServletRequest req) {

        Map<String, Object> resultMap = new HashMap<>();
        try{

            int userNo = ((MemberVO)req.getSession().getAttribute("userInfo")).getUserNo();

            request.setWriter(userNo);
            int result = service.insertNotice(request);

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



    @GetMapping("/qa/noticemodify")
    public ModelAndView noticeModify(@RequestParam(value="noticeNo") Integer noticeNo) {
        ModelAndView view = new ModelAndView();
        Map<String, Object> param = new HashMap<>();
        try{

            param.put("noticeNo", noticeNo);
            NoticeVO vo = service.selectNoticeDetail(param);
            view.addObject("notice", vo);

        }catch(Exception e) {
            e.printStackTrace();
        }

        view.setViewName("views/notice/adminModifyNotice");
        return view;
    }


    @PostMapping("/qa/notice/update")
    @ResponseBody
    public  Map<String, Object> updateNotice(@ModelAttribute NoticeVO noticeNo,
                                              HttpServletRequest req) {

        Map<String, Object> resultMap = new HashMap<>();
        try{

            int result = service.updateNotice(noticeNo);

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


    @GetMapping("/qa/notice/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value="noticeNo") Integer noticeNo) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> param = new HashMap<>();
        try{
            param.put("noticeNo", noticeNo);
            int result = service.deleteNotice(param);

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
