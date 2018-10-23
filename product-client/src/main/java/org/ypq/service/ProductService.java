package org.ypq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.ypq.api.ProductAPI;

@FeignClient(value = "eureka-provider")
public interface ProductService extends ProductAPI {

}
