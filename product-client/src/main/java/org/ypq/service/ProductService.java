package org.ypq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.ypq.api.ProductAPI;
import org.ypq.conf.FeignConfiguration;

@FeignClient(value = "eureka-provider", configuration =  FeignConfiguration.class)
public interface ProductService extends ProductAPI {

}
