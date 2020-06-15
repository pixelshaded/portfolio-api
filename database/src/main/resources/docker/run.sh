#!/bin/bash
docker stop db
docker rm db
docker run -d --name db -p 3306:3306 \
-e MYSQL_DATABASE=portfolio \
-e MYSQL_USER=portfolio \
-e MYSQL_PASSWORD=portfolio \
-e MYSQL_RANDOM_ROOT_PASSWORD=random \
pixelshaded/portfolio-db:1.0