package org.ypq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ypq.api.ProductAPI;
import org.ypq.conf.FeignConfiguration;
import org.ypq.domain.Product;

import java.util.List;

@FeignClient(value = "zuul", configuration =  FeignConfiguration.class)
public interface ZuulService {

    @RequestMapping(value = "/product-api/getOneProduct")
    public Product getOneProduct(@RequestParam("id") Integer id);

    @RequestMapping(value = "/product-api//getProducts")
    public List<Product> getProducts();

    @RequestMapping(value = "/product-api//updateProduct")
    public Product updateProduct(@RequestParam("id") Integer id);

    @RequestMapping(value = "/product-api//batchProducts", method = RequestMethod.POST)
    public List<Product> batchProducts(@RequestBody List<Integer> ids);

}
