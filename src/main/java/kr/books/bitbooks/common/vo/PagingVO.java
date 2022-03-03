package kr.books.bitbooks.common.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PagingVO {
    private int countPerPage = 10;    //한 페이지당 게시물 수. 기본 10개. 생성자 initVal 입력시 변경 됨.

    private int totalCount;                //전체 게시물 수
    private int currentPage;                //현재 페이지.
    private int lastRow;                    //현 페이지에서 마지막 게시물. ex)2 페이지인 경우 20번째 게시물
    private int startRow;                    //현 페이지에서 시작 게시물. ex)2 페이지인 경우 11번째 게시물

    private int totalPage;                    //전체 페이지 수. ceil(전체 게시물 / 페이지당 수)
    private int pageRangeStart;                //웹 페이지 하단 페이지 표시 부분. 시작번호. COUNT_PER_PAGE와 연동됨.
    private int pageRangeEnd;                //웹 페이지 하단 페이지 표시 부분. 끝번호. COUNT_PER_PAGE와 연동됨.
    private int prevPage;
    private int nextPage;

    private int startRowNumCurrentPage;    //리스트 페이지의 No(단순 증가 번호).

    public PagingVO() {
        countPerPage = 10;
    }

    public PagingVO(int initVal) {
        countPerPage = initVal;
    }

    public void setCountPerPage(String countPerPage) {
        if (countPerPage == null || countPerPage.equals("0")) {
            this.countPerPage = 10;
        } else {
            this.countPerPage = Integer.parseInt(countPerPage);
        }
    }

    //게시물이 없어 0일 경우, 1로 기본값 세팅.
    public void setTotalCount(int totalCount) {
        if (totalCount < 1) {
            this.totalCount = 1;
        } else {
            this.totalCount = totalCount;
        }
    }

    //현재 페이지 설정시,  현재 페이지의 시작 게시물 번호와 마지막 게시물 번호도 세팅
    public void setCurrentPage(String currentPage) {
        if (currentPage == null || currentPage.contentEquals("0")) {
            setCurrentPage(1);
        } else {
            setCurrentPage(Integer.parseInt(currentPage));
        }
    }

    //현재 페이지 설정시,  현재 페이지의 시작 게시물 번호와 마지막 게시물 번호도 세팅
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;

        lastRow = currentPage * countPerPage;
        startRow = lastRow - countPerPage;

        if (startRow < 0) {
            startRow = 0;
        }
        if (lastRow <= 0) {
            lastRow = 10;
        }
        if (lastRow >= totalCount) {
            lastRow = totalCount;
        }

        //전체 게시물 수로 전체 페이지 계산.
        totalPage = (int) Math.ceil((double) totalCount / (double) countPerPage);

        //현제 페이지로 웹 페이지 하단에 있는 페이지 범위 끝 계산.
        pageRangeEnd = (int) Math.ceil((double) currentPage / (double) countPerPage) * countPerPage;

        //현제 페이지로 웹 페이지 하단에 있는 페이지 범위 시작 계산.
        pageRangeStart = pageRangeEnd - countPerPage + 1;
        if (pageRangeStart <= 0) {
            pageRangeStart = 1;
        }
        if (pageRangeEnd > totalPage) {
            pageRangeEnd = totalPage;
        }
        if (pageRangeEnd == 0) {
            pageRangeEnd = 1;
        }

        if (currentPage > 1) {
            prevPage = currentPage - 1;
        } else {
            prevPage = 1;
        }
        if (nextPage < totalPage) {
            nextPage = currentPage + 1;
            if (nextPage >= totalPage) {
                nextPage = totalPage;
            }
        } else {
            nextPage = totalPage;
        }
    }

    //지금은 안씀...나중에 필요해서 남겨둠 
    public String getPager() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
