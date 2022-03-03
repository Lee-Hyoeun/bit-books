package kr.books.bitbooks.notice.vo;

import lombok.Data;

@Data
public class NoticeRequest {

    private String noticeTitle;
    private String noticeContent;
    private int writer;

}
