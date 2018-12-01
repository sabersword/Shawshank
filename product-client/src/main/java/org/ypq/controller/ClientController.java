package org.ypq.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ypq.api.ProductAPI;
import org.ypq.domain.Product;
import org.ypq.service.ClientProductService;
import org.ypq.service.ProductService;
import org.ypq.service.TestHystrixCollapser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL;
import static com.netflix.hystrix.HystrixCollapser.Scope.REQUEST;

@RestController
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientProductService clientProductService;
    @Autowired
    private TestHystrixCollapser testHystrixCollapser;

    @RequestMapping(value = "/getOneProduct")
    public Product getOneProduct(Integer id) throws InterruptedException, ExecutionException {
        return clientProductService.getOneProduct(id);
    }

    @RequestMapping(value = "/getProducts")
    public List<Product> getProducts() {
        return clientProductService.getProducts();
    }

    @RequestMapping(value = "/updateProduct")
    public Product updateProduct(int id) {
        return clientProductService.updateProduct(id);
    }

}
