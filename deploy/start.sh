#!/bin/bash
if [ -z "$1" ]
then
  echo "参数不符合,请带上profile,如server1,server2"
else
  echo "得到参数$1,启动程序"
  nohup java -jar eureka-server-*.jar --spring.profiles.active="$1" > "$1".log 2>&1 &
fi


nohup java -jar product-service-*.jar --spring.profiles.active=aliyun > service.log 2>&1 &