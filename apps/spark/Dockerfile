FROM openjdk:alpine
COPY target/spark-service-jar-with-dependencies.jar config/spark-service.properties /opt/spark-service/
ENTRYPOINT ["java", "-jar", "/opt/spark-service/spark-service-jar-with-dependencies.jar"]
