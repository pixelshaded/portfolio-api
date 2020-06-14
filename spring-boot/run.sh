#!/bin/bash
docker stop portfolio-api-spring-boot
docker rm portfolio-api-spring-boot
docker run -d -p 8080:8080 --name portfolio-api-spring-boot --link db \
-e PORTFOLIO_API_SPRING_BOOT_DATABASE_URL=jdbc:mysql://db:3306 \
-e PORTFOLIO_API_SPRING_BOOT_DATABASE_USER=portfolio \
-e PORTFOLIO_API_SPRING_BOOT_DATABASE_PASSWORD=portfolio \
pixelshaded/portfolio-api-spring-boot
