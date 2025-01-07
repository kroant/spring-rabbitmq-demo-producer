# Spring RabbitMQ Demo Producer

## Requirements
- JDK 21
- Docker

## How to run
Build the application and run tests:

`./gradlew clean build`

Run RabbitMQ in Docker

`docker run --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management`

Run the application:

`./gradlew bootRun`

### Open RabbitMQ Management console (optional)

[http://localhost:15672](http://localhost:15672)

Credentials: guest/guest

### Run in Docker (optional)

Build the image:

`./gradlew bootBuildImage`

Run the application:

`docker run spring-rabbitmq-demo-producer:latest`

## Task
Produces RabbitMQ messages.