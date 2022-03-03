package kr.books.bitbooks.member.vo;

import lombok.Data;

@Data
public class MemberRequest {

    private String userId;
    private String userPw;
    private String userName;
    private String genre;

}
