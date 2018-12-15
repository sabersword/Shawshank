package org.ypq.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ypq.domain.Product;
import org.ypq.service.ClientProductService;
import org.ypq.service.ZuulService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ZuulController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulController.class);

    @Autowired
    private ZuulService zuulService;

    @RequestMapping(value = "/zuul/getOneProduct")
    public Product getOneProduct(Integer id) throws InterruptedException, ExecutionException {
        LOGGER.info("通过zuul路由");
        return zuulService.getOneProduct(id);
    }

    @RequestMapping(value = "/zuul/getProducts")
    public List<Product> getProducts() {
        LOGGER.info("通过zuul路由");
        return zuulService.getProducts();
    }

    @RequestMapping(value = "/zuul/updateProduct")
    public Product updateProduct(int id) {
        LOGGER.info("通过zuul路由");
        return zuulService.updateProduct(id);
    }

}
