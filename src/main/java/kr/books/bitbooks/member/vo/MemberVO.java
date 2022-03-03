package kr.books.bitbooks.member.vo;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class MemberVO {

    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String genre;
    private int coin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime upDate;
    private String enabled;
}
