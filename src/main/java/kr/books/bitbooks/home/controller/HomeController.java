package kr.books.bitbooks.home.controller;


import kr.books.bitbooks.home.service.HomeService;
import kr.books.bitbooks.home.vo.HomeBookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;


    @GetMapping("/home/bestseller")
    public Map<String, Object> bestSeller() {

        Map<String, Object> resultMap = new HashMap<>();

        try{
            List<HomeBookVO> bestSeller = service.getBestSeller();
            resultMap.put("bestSeller", bestSeller);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    @GetMapping("/home/newbook")
    public Map<String, Object> newArrivals() {

        Map<String, Object> resultMap = new HashMap<>();

        try{
            List<HomeBookVO> newBook = service.getNewArrivals();
            resultMap.put("newBook", newBook);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

}
