package kr.books.bitbooks.coin.mapper;

import kr.books.bitbooks.coin.vo.CoinHistoryVo;
import kr.books.bitbooks.common.vo.PagingVO;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CoinMapper {

	int getCoinHistoryCount(int userNo) throws Exception;
	
	//List<CoinHistoryVo> getCoinHistoryList(int userNo, PagingVO page) throws Exception;
	List<CoinHistoryVo> getCoinHistoryList(HashMap<String, Object> map) throws Exception;
	
	// insert쿼리 호출하는 메서드(params 게시글 정보를 담아옴)
	public int insertCoinHistory(CoinHistoryVo params);
	
    
}