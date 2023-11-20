# Build Stage
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /opt/AnimalRegistry
COPY target/AnimalRegistry-0.0.1-SNAPSHOT.jar /opt/AnimalRegistry
#COPY target/opentelemetry-javaagent.jar /opt/todobackend
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
#ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"

# Next Stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt/AnimalRegistry
COPY --from=build /opt/AnimalRegistry /opt/AnimalRegistry


ENTRYPOINT ["java","-jar","-javaagent:/opt/AnimalRegistry/opentelemetry-javaagent.jar","AnimalRegistry-0.0.1-SNAPSHOT.jar"]

#FROM adoptopenjdk/openjdk11:alpine
#COPY target/spring-cloud-open-telemetry1-1.0.0-SNAPSHOT.jar spring-cloud-open-telemetry.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/spring-cloud-open-telemetry.jar"]