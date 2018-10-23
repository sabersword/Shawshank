#!/bin/bash
nohup java -jar eureka-server-*.jar --spring.profiles.active=server1 > log/server1.log 2>&1 &
nohup java -jar eureka-server-*.jar --spring.profiles.active=server2 > log/server2.log 2>&1 &
nohup java -jar product-service-*.jar --spring.profiles.active=aliyun > log/service.log 2>&1 &