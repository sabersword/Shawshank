package org.ypq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.ypq.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL;

@Component
public class TestHystrixCollapser {


    @HystrixCollapser(batchMethod = "batchGetProduct", scope = GLOBAL,collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "500"),
            @HystrixProperty(name = "maxRequestsInBatch", value = "200")
    })
    public Future<Product> multiGetProduct(Integer id) {
        return null;
    }


    @HystrixCommand
    public List<Product> batchGetProduct(List<Integer> ids) {
        System.err.println("合并请求!");
        List<Product> products = new ArrayList<>();
        for (Integer id : ids) {
            Product product = new Product();
            product.setName("a");
            products.add(product);
        }
        return products;
    }
}
