# Docker Applications

Playing around with packaging and configuring JVM applications in Docker.

## Java Service Frameworks

- [Spring Boot](https://projects.spring.io/spring-boot/) _takes an opinionated view of building production-ready Spring applications. Spring Boot favors convention over configuration and is designed to get you up and running as quickly as possible._

- [Spark](http://sparkjava.com/) _a micro framework for creating web applications in Kotlin and Java 8 with minimal effort_

### Requirements

- [x] external configuration
- [x] log shipping (syslog?)
- [ ] monitoring
- [ ] metrics

## Docker Base Image

The containers use the [OpenJDK](https://hub.docker.com/\_/openjdk/) image that is build on the [Alpine](https://hub.docker.com/\_/alpine/) image. _Alpine Linux is much smaller than most distribution base images (~5MB), and thus leads to much slimmer images in general._

## Running

A simple `docker-compose.yml` is available to provision the full docker environment -

```console
docker-compose up -d
```

To monitor the service logs -

```console
docker-compose logs -f
```

## Building

To build an application and package as a docker container -

```console
./build (spark|springboot)
```

To redeploy a container after a build -

```console
docker-compose up -d --force-recreate --no-deps spring-boot
```

## HTTP

```console
curl localhost:[port]
```

Port is `8080` for `spring-boot` and `4567` for `spark`

## Logging

A simple logging service ships container logs to a configured [Elastic stack](https://www.elastic.co/) using [filebeat](https://www.elastic.co/products/beats/filebeat). Provisioning an stack is as easy as provisioning the example [Elastic stack-docker](https://github.com/elastic/stack-docker).

> Note that the logging container is configured to join the `stackdocker_stack`
> network to allow log to be shipped to the Elastic stack

To build and run the logging service -

```console
./build logging
```
