package org.ypq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ypq.api.ProductAPI;
import org.ypq.domain.Product;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = {"ypq.cache"})
@RestController
public class ProductController implements ProductAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

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

    @Cacheable(key = "'productCache' + #id")
    @RequestMapping(value = "/get")
    public Product get(int id) {
        LOGGER.info("对id={}进行了缓存", id);
        // TODO 数据库耗时操作
        return new Product(id, "我要测试缓存");
    }

    @CacheEvict(key = "'productCache' + #id")
    @RequestMapping(value = "/delete")
    public void delete(int id) {
        LOGGER.info("删除了id={}的缓存", id);
    }

}
