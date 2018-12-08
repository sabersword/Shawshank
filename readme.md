#### 注意事项

- eureka-server不但做**eureka集群**,同时做过**spring-boot-admin**也做**turbine**(hystrix监控数据的聚合)和**hystrix-dashboard**
- eureka-server分别是8761,8762端口,地址http://aliyun-eureka1:8761/, http://aliyun-eureka1:8762/
- 两套service分别是8090,8091端口
- 两套client分别是8081,8082端口
- spring-boot-admin的地址是http://aliyun-eureka1:8761/admin
- Jenkins使用8080端口,地址是http://spring-boot-host:8080,用户名密码root/root
- **各节点健康监控endpoint增加了前缀/actuator**
- 单节点hystrix数据地址是/actuator/hystrix.stream
- turbine数据地址是http://docker-host:8761/turbine.stream
- hystrix-dashboard的地址是http://aliyun-eureka1:8761/hystrix


##### 服务提供方

1. 本地不能使用redis,阿里云上可以使用
