package kr.books.bitbooks.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Member implements Serializable{
	private static final long serialVersionUID = 5965448709809155461L;
	
	private int userNo;
	
	private String userId;
	
	private String userPw;
	
	private String userName;
	
	private String genre;
	private int coin;
	
	private Date regDate;
	private Date updDate;
	
	private List<MemberAuth> authList;
	
	
	
}
