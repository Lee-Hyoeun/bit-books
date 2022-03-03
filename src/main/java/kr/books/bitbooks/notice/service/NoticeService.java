package kr.books.bitbooks.notice.service;


import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.notice.mapper.NoticeMapper;
import kr.books.bitbooks.notice.vo.NoticeRequest;
import kr.books.bitbooks.notice.vo.NoticeVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NoticeService {

    private NoticeMapper mapper;

    public int getNoticeCount() throws Exception {
        return mapper.getNoticeCount();
    }

    public List<NoticeVO> getNoticeList(PagingVO page) throws Exception {
        return mapper.getNoticeList(page);
    }

    public NoticeVO selectNoticeDetail(Map<String, Object> param) throws Exception{
        return mapper.selectNoticeDetail(param);
    }

    public int insertNotice(NoticeRequest request) throws Exception {
        return mapper.insertNotice(request);
    }

    public int updateNotice(NoticeVO noticeVO) throws Exception {
        return mapper.updateNotice(noticeVO);
    }

    public int deleteNotice(Map<String, Object> param) throws Exception{
        return mapper.deleteNotice(param);
    }
}
