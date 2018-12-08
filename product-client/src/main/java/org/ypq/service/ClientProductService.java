package org.ypq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ypq.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL;
import static com.netflix.hystrix.HystrixCollapser.Scope.REQUEST;

@Service
public class ClientProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientProductService.class);

    @Autowired
    private ProductService productService;

    // TODO 改成REQUEST试试
    @HystrixCollapser(batchMethod = "batchGetOneProduct", scope = GLOBAL,collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "500"),
            @HystrixProperty(name = "maxRequestsInBatch", value = "200")
    })
    public Product getOneProduct(Integer id) {
        return null;
    }
    @HystrixCommand
    public List<Product> batchGetOneProduct(List<Integer> ids) {
        LOGGER.info("消费方-进行合并请求,总共有{}个id,他们分别是{}", ids.size(), ids.toArray());
        List<Product> products = productService.batchProducts(ids);
        return products;
    }


    @HystrixCommand(fallbackMethod = "getProductsFallBack", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "15")
    })
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    public List<Product> getProductsFallBack() {
        Product product = new Product();
        product.setId(-1);
        product.setName("服务器开小差了,请稍候再试");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return products;
    }


    public Product updateProduct(Integer id) {
        return productService.updateProduct(id);
    }


}
