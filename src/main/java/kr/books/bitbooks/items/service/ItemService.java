package kr.books.bitbooks.items.service;

import kr.books.bitbooks.items.mapper.ItemMapper;
import kr.books.bitbooks.items.vo.ItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    public List<ItemResponse> getProductList(Map<String, Object> param) throws Exception {
        return itemMapper.getProductList(param);
    }

    public  ItemResponse getProductDetail(Map<String, Object> param) throws Exception {
        return  itemMapper.getProductDetail(param);
    }

}
