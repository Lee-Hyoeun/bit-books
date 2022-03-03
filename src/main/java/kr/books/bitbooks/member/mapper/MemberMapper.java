package kr.books.bitbooks.member.mapper;
import kr.books.bitbooks.domain.Member;
import kr.books.bitbooks.member.vo.MemberRequest;
import kr.books.bitbooks.member.vo.MemberVO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

	public int getMemberCoin(int userNo);
	
	// 코인 업데이트용
	public int updateCoin(MemberVO params);

	MemberVO getMember(Map<String, Object> param) throws Exception;

	int userSignUp(MemberRequest request) throws Exception;
}