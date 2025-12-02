# Spring gRPC Demo

A minimal Kotlin + Spring Boot service exposing a gRPC endpoint.

## How to build

- Run gradle build: `./gradlew build`
- The gradle build generates gRPC stubs from the `.proto` during the build.

## How to run

- start the spring boot app
- Call the service 
  - using `local/api.http`, or
  - Using grpcurl:
    ```shell
    grpcurl -plaintext -d '{"name":"Frodo"}' localhost:50051 greet.Greeter/SayHello
    ```
