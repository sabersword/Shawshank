package org.ypq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Cacheable(key = "'productCache' + #id")
    public Product getOneProduct(Integer id) {
        LOGGER.info("getOneProduct方法没有命中缓存,id={}", id);
        Product product = new Product();
        product.setId(id);
        product.setName("test11");
        return product;
    }

    @Override
    @Cacheable(key = "'productCache-all'")
    public List<Product> getProducts() {
        LOGGER.info("getProducts方法没有命中缓存,id={}");
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setName("test2");
        products.add(product);
        product = new Product();
        product.setId(2);
        product.setName("test1写死我测试啊");
        products.add(product);
        product = new Product();
        product.setId(3);
        product.setName("test7");
        products.add(product);
        return products;
    }

    @Override
    @CacheEvict(key = "'productCache' + #id")
    public Product updateProduct(Integer id) {
        LOGGER.info("updateProduct方法清除缓存,id={}", id);
        Product product = new Product();
        product.setId(id);
        product.setName("test-update-product");
        return product;
    }


}
