package org.ypq.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.ypq.domain.Product;

import java.util.List;

//@RequestMapping("/product-service-api")
public interface ProductAPI {

    @RequestMapping(value = "/getOneProduct")
    public Product getOneProduct(int id);

    @RequestMapping(value = "/getProducts")
    public List<Product> getProducts();

}
