package org.ypq.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ypq.domain.Product;

import java.util.List;

@RequestMapping("/product-service-api")
public interface ProductAPI {

    @RequestMapping(value = "/getOneProduct")
    public Product getOneProduct(@RequestParam("id") Integer id);

    @RequestMapping(value = "/getProducts")
    public List<Product> getProducts();

    @RequestMapping(value = "/updateProduct")
    public Product updateProduct(@RequestParam("id") Integer id);

    @RequestMapping(value = "/batchProducts", method = RequestMethod.POST)
    public List<Product> batchProducts(@RequestBody List<Integer> ids);

}
