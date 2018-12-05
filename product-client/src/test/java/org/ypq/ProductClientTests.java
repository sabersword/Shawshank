package org.ypq;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.ypq.domain.Product;
import org.ypq.mq.Sender;
import org.ypq.service.ProductService;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableEurekaClient
@EnableFeignClients
@ActiveProfiles({"aliyun"})
public class ProductClientTests {

	@Autowired
	private Sender sender;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductClientTests.class);

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void testSender() throws InterruptedException {
//	    Random random = new Random();
//		while(true) {
//		    Thread.sleep(1000);
//            if (random.nextInt(2) > 0 ) {
//                sender.sendInfo();
//            } else {
//                sender.sendError();
//            }
//        }
//	}

    @Test
    public void testEurekaClient() throws InterruptedException {
	    for (int i = 0; i < 10; i++) {
            ServiceInstance si = loadBalancerClient.choose("eureka-provider");
            StringBuffer sb = new StringBuffer("");
            sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/product-service-api/getProducts");
            logger.info("第{}次ribbon获取的地址是{}", i, sb.toString());
            RestTemplate rt = new RestTemplate();
            ParameterizedTypeReference<List<Product>> typeReference = new ParameterizedTypeReference<List<Product>>() {
            };
            ResponseEntity<List<Product>> responseEntity = rt.exchange(sb.toString(), HttpMethod.GET, null, typeReference);
            List<Product> plist = responseEntity.getBody();
            for (Product p : plist) {
                logger.info("{}, {}", p.getId(), p.getName());
            }
            Assert.assertEquals(3, plist.size());
        }

    }

    @Test
    public void testFeign() {
	    List<Product> products = productService.getProducts();
        for (Product p : products) {
            logger.info("{}, {}", p.getId(), p.getName());
        }
        Assert.assertEquals(3, products.size());
    }

}
