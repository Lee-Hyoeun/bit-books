package kr.books.bitbooks.coin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.books.bitbooks.coin.mapper.CoinMapper;
import kr.books.bitbooks.coin.vo.CoinHistoryVo;
import kr.books.bitbooks.common.vo.PagingVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoinService {

    private CoinMapper mapper;
    
    public int insertCoinHistory(CoinHistoryVo coinHistoryVo)throws Exception {
    	return mapper.insertCoinHistory(coinHistoryVo);
    }
    
    public int getCoinHistoryCount(int userNo) throws Exception {
        return mapper.getCoinHistoryCount(userNo);
    }

    public List<CoinHistoryVo> getCoinHistoryList(int userNo, PagingVO page) throws Exception {
        //return mapper.getCoinHistoryList(userNo, page);
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("userNo", userNo);
    	map.put("page", page);

    	return mapper.getCoinHistoryList(map);
    }

}

