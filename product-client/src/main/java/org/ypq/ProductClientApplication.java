package org.ypq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
        System.out.println("bug commit 1  C3");
        System.out.println("bug commit 2  C4");
        System.out.println("bug commit 3  C10");
    }

    public void test() {
        System.out.println("master commit 1 C5");
        System.out.println("master commit 2 C6");
    }

    public void hotfix() {
        System.out.println("hotfix commit  1  C8");
    }
}

