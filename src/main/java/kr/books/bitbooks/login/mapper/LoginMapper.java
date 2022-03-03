package kr.books.bitbooks.login.mapper;

import kr.books.bitbooks.login.vo.LoginRequest;
import kr.books.bitbooks.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface LoginMapper {

    MemberVO login(LoginRequest request) throws SQLException;
}
