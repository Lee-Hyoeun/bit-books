package kr.books.bitbooks.coin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.books.bitbooks.common.utils.HttpUtils;
import kr.books.bitbooks.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.books.bitbooks.coin.service.CoinService;
import kr.books.bitbooks.coin.vo.CoinHistoryVo;
import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.member.vo.MemberVO;
import lombok.AllArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CoinController {
	
	private final CoinService service;

    private final MemberService memberService;

    public static final String API_URL = "https://api.iamport.kr/";
    public static final String IMP_KEY = "0076092537895634";
    public static final String IMP_SECRET = "KrlgsGptHa7K7lku3bpDQK8PhXJgMhnwJIMcobF6mMRu8bYbnnOd8X2pUMGG43cOLY0aaGgxt81Bj0NG";

    @Autowired
    HttpUtils httpUtils;

    
    @GetMapping("/coin/log")
    public ModelAndView CoinLog(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage
    			, HttpServletRequest request) {
    	    	
    	ModelAndView view = new ModelAndView();
    	view.setViewName("views/coin/cash_log");

        try {
        	HttpSession session = request.getSession();
        	if(session == null) {
        		view.setViewName("views/login/login");
                return view;
        	}
        	MemberVO vo = (MemberVO) session.getAttribute("userInfo");
            if(vo == null) {
        		view.setViewName("views/login/login");
                return view;
        	}
        	
        	//페이징 처리 객체 선언 
        	PagingVO pagingVO = new PagingVO();

        	System.out.println("getUserNo:" + vo.getUserNo());
        	
        	//운영자 게시판 게시물 총 개수 
            int totalCount = service.getCoinHistoryCount(vo.getUserNo());

           // 전체 개수 넣어준다 
            pagingVO.setTotalCount(totalCount);
            
            
            // 현재 페이지 넣어준다 
            pagingVO.setCurrentPage(currentPage);
            System.out.println("currentPage:" + currentPage);
            System.out.println("totalCount:" + totalCount);

            //페이지 범위내에서 출력될 게시판 목록 리스트 가져오기 
            List<CoinHistoryVo> CoinHistoryList = service.getCoinHistoryList(vo.getUserNo(), pagingVO);
            System.out.println("CoinHistoryList:" + CoinHistoryList.size());
            
            for(int i=0;i<CoinHistoryList.size();i++){
                CoinHistoryList.get(i).setHistoryNo(i+1+(currentPage-1)*pagingVO.getCountPerPage());
            } 
                        
            //view 를 호출할때 넘겨줄 데이터  정의 
            view.addObject("currentPage", currentPage);
            view.addObject("paging", pagingVO);
            view.addObject("totalCount", totalCount);
            view.addObject("dataList", CoinHistoryList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @RequestMapping("/pay/complete")
    @ResponseBody
    public Map<String, Object> complete(@RequestParam(value ="payAmount") Integer payAmount,
                                        HttpServletRequest request ) {

        MemberVO member =  (MemberVO) request.getSession().getAttribute("userInfo");
        Map<String, Object> resultMap = new HashMap<>();
        try{

            if(member == null) {
                throw new Exception("사용자가 로그인상태가 아님");
            }else {

                member.setCoin(member.getCoin() + payAmount);
                int result = memberService.updateCoin(member);

                if(result > 0) {
                    CoinHistoryVo vo = new CoinHistoryVo();
                    vo.setAmount(payAmount);
                    vo.setUserNo(member.getUserNo());
                    service.insertCoinHistory(vo);

                    resultMap.put("resultCode", 200);
                }else {
                    resultMap.put("resultCode", 400);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            resultMap.put("resultCode", 500);
        }

        return resultMap;
    }

}
