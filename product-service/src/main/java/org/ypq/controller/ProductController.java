package org.ypq.controller;

import org.springframework.web.bind.annotation.RestController;
import org.ypq.api.ProductAPI;
import org.ypq.domain.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController implements ProductAPI {

    @Override
    public Product getOneProduct(int id) {
        Product product = new Product();
        product.setId(11);
        product.setName("test11");
        return product;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setName("test1");
        products.add(product);
        product = new Product();
        product.setId(2);
        product.setName("test2");
        products.add(product);
        product = new Product();
        product.setId(3);
        product.setName("test3");
        products.add(product);
        return products;
    }
}
