#!/bin/bash
cd /root/redis/redisCluster/
rm *.aof *.rdb *.pid nodes1000*
redis-server redis10000.conf
redis-server redis10001.conf
redis-server redis10002.conf
redis-server redis10003.conf
redis-server redis10004.conf
redis-server redis10005.conf
