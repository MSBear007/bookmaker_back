cp target/broker-0.0.1-SNAPSHOT.jar src/main/docker
cd src/main/docker
docker-compose down
docker rmi docker-spring-boot-postgres:latest
docker-compose up