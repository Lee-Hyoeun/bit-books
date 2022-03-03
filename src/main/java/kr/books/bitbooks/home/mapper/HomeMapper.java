package kr.books.bitbooks.home.mapper;

import kr.books.bitbooks.home.vo.HomeBookVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HomeMapper {

    List<HomeBookVO> getBestSeller() throws SQLException;

    List<HomeBookVO> getNewArrivals() throws SQLException;

}
