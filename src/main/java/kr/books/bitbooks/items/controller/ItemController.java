package kr.books.bitbooks.items.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import kr.books.bitbooks.common.CategoryTypeEnum;
import kr.books.bitbooks.items.service.ItemService;
import kr.books.bitbooks.items.vo.ItemRequest;
import kr.books.bitbooks.items.vo.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/item")
    public ModelAndView itemsView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("views/items/upload");
        return view;
    }


    @PostMapping("/item")
    public ModelAndView itemsView(@ModelAttribute ItemRequest request) {
        ModelAndView view = new ModelAndView();

        return view;
    }

    @GetMapping("/product/prods")
    public ModelAndView prods(@RequestParam(value="codeValue") String codeValue) {
        ModelAndView view = new ModelAndView();

        Map<String, Object> param = new HashMap<>();
        param.put("codeValue", codeValue);

        try {

            String title = CategoryTypeEnum.value(codeValue).getValue();
            List<ItemResponse> productList =
                    itemService.getProductList(param);

            view.addObject("title", title);
            view.addObject("prdList", productList);

        }catch(Exception e) {
            e.printStackTrace();
        }
        view.setViewName("views/product/prods");
        return view;
    }


    // 상품 구매
    @GetMapping("/product/LookProductUser")
    public ModelAndView LookProductUser(@RequestParam(value="itemId") Integer itemId) {
        ModelAndView view = new ModelAndView();

        Map<String, Object> param = new HashMap<>();
        param.put("itemId", itemId);
        
        try {
            ItemResponse product =   itemService.getProductDetail(param);
            view.addObject("book", product);
           
        }catch(Exception e) {
            e.printStackTrace();
        }

        view.setViewName("views/product/lookproductuser");
        return view;
    }
}
