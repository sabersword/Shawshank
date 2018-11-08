package org.ypq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ypq.domain.Product;
import org.ypq.service.ProductService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/testGetOneProduct")
    public Product getOneProduct(int id) {
        Product product = new Product();
        product.setId(11);
        product.setName("test11");
        return product;
    }

    @RequestMapping(value = "/testGetProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/get")
    public Product get(int id) {
        // TODO 数据库耗时操作
        return new Product(id, "我要测试缓存");
    }

    @RequestMapping(value = "/delete")
    public void delete(int id) {
    }

}
