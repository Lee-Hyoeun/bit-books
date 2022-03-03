package kr.books.bitbooks.purchase.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PurchaseVO {
	
	private int purchaseNo;
	private int userNo;
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String fileName;
	private int purchaseCount;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
}
