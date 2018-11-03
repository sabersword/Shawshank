#!/bin/bash
nohup java -jar product-service-*.jar --spring.profiles.active=aliyun-service1 > log/service1.log 2>&1 &
nohup java -jar product-service-*.jar --spring.profiles.active=aliyun-service2 > log/service2.log 2>&1 &