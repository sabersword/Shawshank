#!/usr/bin/env bash

. /etc/profile
directory=`pwd`
mvn clean package -Dmaven.test.skip=true


cd $directory/eureka-server
mvn docker:build
cd $directory/product-service
mvn docker:build
cd $directory/product-client
mvn docker:build

docker ps | grep 'eureka-server'|awk '{print $1}'|xargs -r docker rm -f
docker run -v /root/dockerlog -d -p 8761:8761 -e "SPRING_PROFILES_ACTIVE=server1" --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/eureka-server
docker run -v /root/dockerlog -d -p 8762:8762 -e "SPRING_PROFILES_ACTIVE=server2" --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/eureka-server

docker ps | grep 'product-service'|awk '{print $1}'|xargs -r docker rm -f
docker run -v /root/dockerlog -d -p 8090:8090 -e "SPRING_PROFILES_ACTIVE=aliyun-service1" --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-service
docker run -v /root/dockerlog -d -p 8091:8091 -e "SPRING_PROFILES_ACTIVE=aliyun-service2" --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-service

docker ps | grep 'product-client'|awk '{print $1}'|xargs -r docker rm -f
docker run -v /root/dockerlog -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=aliyun" --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-client

docker images | grep none | awk '{print $3}' | xargs -rt docker rmi -f