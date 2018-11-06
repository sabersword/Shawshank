package org.ypq.service;

import org.springframework.stereotype.Service;
import org.ypq.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> generateProducts() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setName("test2");
        products.add(product);
        product = new Product();
        product.setId(2);
        product.setName("test12");
        products.add(product);
        product = new Product();
        product.setId(3);
        product.setName("test7");
        products.add(product);
        return products;
    }
}
