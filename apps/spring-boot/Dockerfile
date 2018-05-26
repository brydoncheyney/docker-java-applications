FROM openjdk:alpine
COPY build/libs/app-0.1.0.jar config/application.properties /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/app-0.1.0.jar", "--spring.config.location=/opt/app/application.properties"]
