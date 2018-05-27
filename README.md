# Docker Applications

Playing around with packaging and configuring JVM applications in Docker.

## Java Service Frameworks

- [Spring Boot](https://projects.spring.io/spring-boot/) _takes an opinionated view of building production-ready Spring applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible._

- [Spark](http://sparkjava.com/) _a micro framework for creating web applications in Kotlin and Java 8 with minimal effort_

## Docker Base Image

The containers use the [OpenJDK](https://hub.docker.com/\_/openjdk/) image that is build on the [Alpine](https://hub.docker.com/\_/alpine/) image. _Alpine Linux is much smaller than most distribution base images (~5MB), and thus leads to much slimmer images in general._

## Running

To build the application, package in a docker container and run -

```console
./deploy (spark|springboot)
```

## HTTP

```console
curl localhost:[port]
```

Port is `8080` for `spring-boot` and `4567` for `spark`
