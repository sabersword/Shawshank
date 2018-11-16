#!/usr/bin/env bash

docker ps | grep '8080'|awk '{print $1}'|xargs -r docker rm -f
docker run -v /root/dockerlog -d -p 8080:8080 --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-service