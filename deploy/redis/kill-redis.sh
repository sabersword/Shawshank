#!/bin/bash
ps -ef | grep redis | grep -v grep | awk '{print $2}' | xargs -r kill -9
