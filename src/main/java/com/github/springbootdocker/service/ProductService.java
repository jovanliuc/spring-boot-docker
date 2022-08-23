package com.github.springbootdocker.service;

import com.github.springbootdocker.dao.ProductDao;
import com.github.springbootdocker.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        List<Product> productList = this.productDao.getProductList();
        return productList;
    }
}
