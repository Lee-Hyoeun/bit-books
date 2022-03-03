package kr.books.bitbooks.home.service;

import kr.books.bitbooks.home.mapper.HomeMapper;
import kr.books.bitbooks.home.vo.HomeBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeMapper homeMapper;

    public List<HomeBookVO> getBestSeller() throws SQLException{
        return homeMapper.getBestSeller();
    }

    public List<HomeBookVO> getNewArrivals() throws SQLException{
        return homeMapper.getNewArrivals();
    }
}
