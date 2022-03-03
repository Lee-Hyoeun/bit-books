package kr.books.bitbooks.login.service;

import kr.books.bitbooks.login.mapper.LoginMapper;
import kr.books.bitbooks.login.vo.LoginRequest;
import kr.books.bitbooks.member.vo.MemberVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    public MemberVO login(LoginRequest request) throws SQLException {
        return loginMapper.login(request);
    }

}
