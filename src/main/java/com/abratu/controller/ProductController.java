package com.abratu.controller;

import com.abratu.entities.Product;
import com.abratu.repositories.ProductRepository;
import com.abratu.util.ResponseBuilder;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET)
    @ResponseBody
    public String getProduct(@PathVariable String productCode) {

        if(StringUtils.isEmpty(productCode)){
            return ResponseBuilder.buildNegativeResponse("Product code is missing");
        }
        try{
            Product product = productRepository.findByCode(productCode);
            Gson gson = new Gson();
            return gson.toJson(product);
        }catch (Exception e){
            return ResponseBuilder.buildNegativeResponse("Product not exists");
        }
    }
}

