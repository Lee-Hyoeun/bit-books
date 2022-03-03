package kr.books.bitbooks.notice.mapper;

import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.notice.vo.NoticeRequest;
import kr.books.bitbooks.notice.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    int getNoticeCount() throws Exception;

    List<NoticeVO> getNoticeList(PagingVO page) throws Exception;

	// insert쿼리 호출하는 메서드(params 게시글 정보를 담아옴)
	public int insertNotice(NoticeVO params);
	
	// 상세조회 select쿼리 호출 메서드(notice_no(pk)를 파라미터로 받아서 해당 게시글 조회)
	public NoticeVO selectNoticeDetail(Map<String, Object> param);
	
	// 수정 update쿼리 호출 메서드
	public int updateNotice(NoticeVO noticeVO);
	
	// 삭제 delete쿼리 호출 메서드
	public int deleteNotice(Map<String, Object> param);
	
	// 게시글 목록 조회하는 select 쿼리 호출 메서드(페이징과 구별)
	public List<NoticeVO> selectNoticeList();

	int insertNotice(NoticeRequest request) throws  Exception;
    
}
