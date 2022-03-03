package kr.books.bitbooks.items.vo;

import lombok.Data;

@Data
public class ItemResponse {

    private int itemId;
    private String itemName;
    private int price;
    private String description;
    private String codeValue;
    private String released;
    private String imgUrl;
    private String fileUrl;
}
