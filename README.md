# gatewayapi
gateway api component written in java

# this app is dockerized.

build:
docker build -t IMG_NAME:TAG --build-arg JAR_FILE=NAME_OF_FILE .

run:
docker run -d -p 8090:8080 -e WORKER_HOST='http://192.168.99.100:8080' IMG_NAME:TAG
