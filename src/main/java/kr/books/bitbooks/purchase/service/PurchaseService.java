package kr.books.bitbooks.purchase.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.purchase.mapper.PurchaseMapper;
import kr.books.bitbooks.purchase.vo.PurchaseVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PurchaseService {

    private PurchaseMapper mapper;
    
    public int insertPurchase(PurchaseVO PurchaseVO)throws Exception {
    	return mapper.insertPurchase(PurchaseVO);
    }
    
    public int getPurchaseCount(int userNo) throws Exception {
        return mapper.getPurchaseCount(userNo);
    }

//    public List<PurchaseVO> getPurchaseList(PagingVO page) throws Exception {
//        return mapper.getPurchaseList(page);
//    }

    public List<PurchaseVO> getPurchaseList(int userNo, PagingVO page) throws Exception {
        //return mapper.getCoinHistoryList(userNo, page);
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("userNo", userNo);
    	map.put("page", page);

    	return mapper.getPurchaseList(map);
    }
}

