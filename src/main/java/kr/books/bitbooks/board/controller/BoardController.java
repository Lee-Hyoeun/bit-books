package kr.books.bitbooks.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.books.bitbooks.board.service.BoardService;
import kr.books.bitbooks.board.vo.BoardVO;
import kr.books.bitbooks.common.vo.PagingVO;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/board/userboardlist")
	public ModelAndView board(@RequestParam(value="currentPage", defaultValue="1") Integer currentPage) {

		ModelAndView view = new ModelAndView();
		
		view.setViewName("views/userBoard/userBoardList");
		
		try {
			
			// 페이징
        	PagingVO pagingVO = new PagingVO();

            int totalCount = service.getBoardCount();

            pagingVO.setTotalCount(totalCount);
            pagingVO.setCurrentPage(currentPage);

            List<BoardVO> noticeList = service.getBoardList(pagingVO);
            
            view.addObject("currentPage", currentPage);
            view.addObject("paging", pagingVO);
            view.addObject("totalCount", totalCount);
            view.addObject("dataList", noticeList);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return view;
	
	}
	
	
    @GetMapping("/board/boardwrite")
    public ModelAndView noticeWrite() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/userBoard/userWriteBoard");
        return view;
    }

    @GetMapping("/board/boardmodify")
    public ModelAndView noticeModify() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/userBoard/userModifyBoard");
        return view;
    }
    

}
