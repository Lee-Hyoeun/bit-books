package kr.books.bitbooks.notice.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class NoticeVO {

    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private int writer;
    private String writerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
}
