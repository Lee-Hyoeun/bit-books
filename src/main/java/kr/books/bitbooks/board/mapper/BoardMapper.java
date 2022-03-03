package kr.books.bitbooks.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.books.bitbooks.board.vo.BoardVO;
import kr.books.bitbooks.common.vo.PagingVO;

@Mapper
public interface BoardMapper {
	
	int getBoardCount() throws Exception;
	
	List<BoardVO> getBoardList(PagingVO page) throws Exception;

	// 게시글 생성하는 insert쿼리 호출하는 메서드(params 게시글 정보를 담아옴)
	public int insertBoard(BoardVO params);
	
	// 상세 게시글을 조회하는 select쿼리 호출 메서드(board_no(pk)를 파라미터로 받아서 해당 게시글 조회)
	public BoardVO selectBoardDetail(int idx);
	
	// 게시글을 수정하는 update쿼리 호출 메서드
	public int updateBoard(BoardVO params);
	
	// 게시글을 삭제하는 delete쿼리 호출 메서드
	public void deleteBoard(int idx);
	
	// 게시글 목록 조회하는 select 쿼리 호출 메서드(페이징과 구별)
	public List<BoardVO> selectBoardList();

	

	
	
}
