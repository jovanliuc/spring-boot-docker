package com.github.springbootdocker.dao;

import com.github.springbootdocker.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getProductList() {
        List<Product> productList = jdbcTemplate.query("select * from product", (resultSet, i) -> {
            String productId = resultSet.getString("product_id");
            String productName = resultSet.getString("product_name");
            String productPrice = resultSet.getString("product_price");

            Product product = new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setProductPrice(productPrice);
            return product;
        });

        return productList;
    }
}
