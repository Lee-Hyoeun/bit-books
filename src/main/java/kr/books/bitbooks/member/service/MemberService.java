package kr.books.bitbooks.member.service;


import kr.books.bitbooks.member.vo.MemberRequest;
import org.springframework.stereotype.Service;

import kr.books.bitbooks.member.mapper.MemberMapper;
import kr.books.bitbooks.member.vo.MemberVO;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberMapper mapper;
    
    public int updateCoin(MemberVO MemberVO)throws Exception {
    	return mapper.updateCoin(MemberVO);
    }
    
    public int getMemberCoin(int userNo)throws Exception {
    	return mapper.getMemberCoin(userNo);
    }

    public MemberVO getMember(Map<String, Object> param) throws Exception{
        return mapper.getMember(param);
    }

    public int userSignUp(MemberRequest request) throws Exception {
        return mapper.userSignUp(request);
    }

}

