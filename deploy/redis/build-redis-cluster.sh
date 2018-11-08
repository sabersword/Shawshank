#!/bin/bash
cd /root/redis/redisCluster/
rm *.aof *.rdb *.pid nodes1000*
redis-server redis10000.conf
redis-server redis10001.conf
redis-server redis10002.conf
redis-server redis10003.conf
redis-server redis10004.conf
redis-server redis10005.conf
echo "yes" | redis-trib.rb create --replicas 1 127.0.0.1:10000 127.0.0.1:10001 127.0.0.1:10002 127.0.0.1:10003 127.0.0.1:10004 127.0.0.1:10005
