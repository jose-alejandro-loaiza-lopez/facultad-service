FROM openjdk:23
LABEL authors="josea"
WORKDIR /app
COPY target/facultad-service-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "facultad-service-0.0.1-SNAPSHOT.jar"]