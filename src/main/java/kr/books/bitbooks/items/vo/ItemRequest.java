package kr.books.bitbooks.items.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ItemRequest {

    private String itemName;
    private int price;
    public  String description;
    public MultipartFile[] files;

}
