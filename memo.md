###zipkin 针对consumer调用provider这个简单调用链
1. sleuth采样率不高, 感觉zipkin有问题
2. 如果有hystrix是请求合并,zipkin会收到很多span,不断递增,具体原理还不了解,估计与请求合并的实现有关
3. 如果只用了hystrix的普通熔断,能够正常使用zipkin.信号量隔离会比线程隔离少一个span
4. 禁用掉hystrix,使用feign的话,会在zipkin看到3条时间线(4个span)
5. 禁用掉hystrix,不使用feign而是使用RestTemplate + Ribbon(@loadBlance), zipkin能看到2条时间线(2个span)
    * RestTemplate请使用自动注入的方式, URL写服务名(不要写IP+端口)
    * 感觉是Ribbon会增加一个span
