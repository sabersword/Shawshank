package org.ypq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ypq.api.ProductAPI;
import org.ypq.domain.Product;
import org.ypq.service.ProductService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getOneProduct")
    public Product getOneProduct(int id) {
        return productService.getOneProduct(id);
    }

    @RequestMapping(value = "/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/updateProduct")
    public Product updateProduct(int id) {
        return productService.updateProduct(id);
    }

}
