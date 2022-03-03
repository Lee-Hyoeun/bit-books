package kr.books.bitbooks.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/test");
        return view;
    }

    // 코드 관리
    @GetMapping("/codeLook/codeLook")
    public ModelAndView codeLook() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/codelook/codelook");
        return view;
    }
    @GetMapping("/codeLook/codeLookMenu")
    public ModelAndView codeLookMenu() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/codelook/codelookmenu");
        return view;
    }
    @GetMapping("/codeLook/codeLookNewCode")
    public ModelAndView codeLookNewCode() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/codelook/codelooknewcode");
        return view;
    }
    @GetMapping("/codeLook/codeUpdate")
    public ModelAndView codeUpdate() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/codelook/codeupdate");
        return view;
    }
    // 상품
    @GetMapping("/product/product")
    public ModelAndView product() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/product/product");
        return view;
    }


    @GetMapping("/product/productnew")
    public ModelAndView productNew() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/product/productnew");
        return view;
    }
    @GetMapping("/product/productUpdate")
    public ModelAndView productUpdate() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/product/productupdate");
        return view;
    }
    // 상품 목록
    @GetMapping("/productList/LookProduct")
    public ModelAndView LookProduct() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/productlist/lookproduct");
        return view;
    }




    @GetMapping("/productList/LookProductPaging")
    public ModelAndView LookProductPaging() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/productlist/lookproductpaging");
        return view;
    }
    
    // 코인 충전
    @GetMapping("/coin/cash")
    public ModelAndView coinCash() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/coin/bit_cash");
        return view;
    }
    
    // 구매 기능
    @GetMapping("/purchase/buyTest")
    public ModelAndView testPurchase() {
      ModelAndView view = new ModelAndView();
      view.setViewName("views/purchase/testPurchase");
      return view;
    }
    
//    // 코인 충전기록
//    @GetMapping("/coin/log")
//    public ModelAndView cashLog() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("views/coin/cash_log");
//        return view;
//    }
    
    // 구매내역 보기
//    @GetMapping("/purchase/log")
//    public ModelAndView buyLog() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("views/purchase/buy_log");
//        return view;
//    }
//    
//    // 구매내역 상세보기
//    @GetMapping("/purchase/log")
//    public ModelAndView buyProduct() {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("views/purchase/buy_product");
//        return view;
//    }
    
    
  
 // 관리자 자유게시판 관리 목록 페이지
    @GetMapping("/admin/boardlist")
    public ModelAndView adminBoardList() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/adminBoard/adminBoardList");
        return view;
    }

    // 관리자 자유게시판 관리 상세 페이지 
    @GetMapping("/admin/boarddetail")
    public ModelAndView adminDetailBoard() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/adminBoard/adminDetailBoard");
        return view;
    }
    



    // 사용자 자유게시판 목록 페이지
    @GetMapping("/user/boardlist")
    public ModelAndView userBoardList() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("views/userBoard/userBoardList");
    	return view;
    }
    
    // 사용자 자유게시판 목록 페이지
    @GetMapping("/user/boarddetail")
    public ModelAndView userDetailBoard() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("views/userBoard/userDetailBoard");
    	return view;
    }
    
    // 사용자 자유게시판 글쓰기 페이지
    @GetMapping("/user/boardwrite")
    public ModelAndView userWriteBoard() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("views/userBoard/userWriteBoard");
    	return view;
    }
    
    // 사용자 자유게시판 수정 페이지
    @GetMapping("/user/boarmodify")
    public ModelAndView userModifyBoard() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("views/userBoard/userModifyBoard");
    	return view;
    }
    
    // 사용자 공지사항 목록 페이지
    @GetMapping("/user/noticelist")
    public ModelAndView userNoticeList() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/userNotice/userNoticeList");
        return view;
    }

    // 사용자 공지사항 상세 페이지
    @GetMapping("/user/noticedetail")
    public ModelAndView userDetailNotice() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/userNotice/userDetailNotice");
        return view;
    }
    

    
    // 회원가입
    @GetMapping("/signup")
    public ModelAndView signUp() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/login/signup");
        return view;
    }
    
    // 회원 목록 보기
    @GetMapping("/user/list")
    public ModelAndView userList() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/user/user_list");
        return view;
    }
    
    // 회원 상세 보기
    @GetMapping("/user/detail")
    public ModelAndView userDetail() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/user/user_detail");
        return view;
    }
    
    // 사용자 홈(로그인 후)
    @GetMapping("/")
    public ModelAndView userHomeLogin() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/home/user_home_login");
        return view;
    }
    
     
}
