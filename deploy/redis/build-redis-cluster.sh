#!/bin/bash
ip=`ifconfig eth0|grep inet|awk '{print $2}'`
cd /root/redis/redisCluster/
rm *.aof *.rdb *.pid nodes1000*
redis-server redis10000.conf
redis-server redis10001.conf
redis-server redis10002.conf
redis-server redis10003.conf
redis-server redis10004.conf
redis-server redis10005.conf
echo "yes" | redis-trib.rb create --replicas 1 $ip:10000 $ip:10001 $ip:10002 $ip:10003 $ip:10004 $ip:10005
