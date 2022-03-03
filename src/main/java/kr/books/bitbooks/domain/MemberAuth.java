package kr.books.bitbooks.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberAuth implements Serializable{

	private static final long serialVersionUID = -9200898589691826811L;
	
	private int userNo;
	private String auth;
}
