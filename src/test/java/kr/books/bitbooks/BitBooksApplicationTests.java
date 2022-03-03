package kr.books.bitbooks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import kr.books.bitbooks.board.mapper.BoardMapper;
//import kr.books.bitbooks.board.vo.BoardVO;

@SpringBootTest
class BitBooksApplicationTests {

    @Test
    void contextLoads() {
    }
    
    @Autowired
   // private BoardMapper boardMapper;
    
    @Test
    public void insert테스트() {
 //   	BoardVO params = new BoardVO();
//    	params.setTitle("첫번째 게시글 제목");
//    	params.setContent("첫번째 게시글 내용");
//    	params.setUserNo(1);
    	
//    	int result = boardMapper.insertBoard(params);
    	
//    	System.out.println("insert 결과~~ "+result);
    }
    

}
