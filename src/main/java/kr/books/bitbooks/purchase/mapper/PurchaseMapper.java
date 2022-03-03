package kr.books.bitbooks.purchase.mapper;

import kr.books.bitbooks.common.vo.PagingVO;
import kr.books.bitbooks.purchase.vo.PurchaseVO;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PurchaseMapper {

	int getPurchaseCount(int perchase) throws Exception;
	
	List<PurchaseVO> getPurchaseList(HashMap<String, Object> map) throws Exception;
	
	// insert쿼리 호출하는 메서드(params 게시글 정보를 담아옴)
	public int insertPurchase(PurchaseVO params);
	
    
}