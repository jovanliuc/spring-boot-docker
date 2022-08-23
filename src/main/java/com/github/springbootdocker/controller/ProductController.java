package com.github.springbootdocker.controller;

import com.github.springbootdocker.model.Product;
import com.github.springbootdocker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProductList() {
        return this.productService.getProductList();
    }
}
