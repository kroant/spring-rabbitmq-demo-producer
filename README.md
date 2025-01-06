# Spring RabbitMQ Demo Producer

## Requirements
- JDK 21

## How to run
Build the application and run tests:

`./gradlew clean build`

Run the application:

`./gradlew bootRun`

### Run in Docker (optional)

Build the image:

`./gradlew bootBuildImage`

Run the application:

`docker run spring-rabbitmq-demo-producer:latest`

## Task
Produces RabbitMQ message.