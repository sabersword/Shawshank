#!/bin/bash
curl -X POST localhost:8080/actuator/shutdown
curl -X POST localhost:8081/actuator/shutdown
curl -X POST localhost:8761/actuator/shutdown
curl -X POST localhost:8762/actuator/shutdown