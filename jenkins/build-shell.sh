#!/usr/bin/env bash

. /etc/profile
pwd
mvn clean package -Dmaven.test.skip=true
cd product-service
mvn docker:build
docker ps | grep '8080'|awk '{print $1}'|xargs -r docker rm -f
docker images | grep none | awk '{print $3}' | xargs -rt docker rmi -f
docker run -v /root/dockerlog -d -p 8080:8080 --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-service
