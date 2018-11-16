#!/usr/bin/env bash

docker run -v /root/dockerlog -d -p 8080:8080 --add-host=docker-host:`docker network inspect  --format='{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge` springboot/product-service