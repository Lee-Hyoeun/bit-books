package kr.books.bitbooks.items.mapper;

import kr.books.bitbooks.items.vo.ItemRequest;
import kr.books.bitbooks.items.vo.ItemResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {

   // int insertItem(ItemRequest request) throws Exception;
    List<ItemResponse> getProductList(Map<String, Object> param) throws Exception;

    ItemResponse getProductDetail(Map<String, Object> param) throws Exception;

}
