package kr.books.bitbooks.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.books.bitbooks.board.mapper.BoardMapper;
import kr.books.bitbooks.board.vo.BoardVO;
import kr.books.bitbooks.common.vo.PagingVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
	
	private BoardMapper bmapper;
	
	public int getBoardCount() throws Exception{
		return bmapper.getBoardCount();
				
	}
	
	public List<BoardVO> getBoardList(PagingVO page) throws Exception{
		return bmapper.getBoardList(page);
	}
	
	

}
