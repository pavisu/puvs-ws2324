FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
COPY target/*.jar app.jar
#ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
#ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM adoptopenjdk/openjdk11:alpine
#COPY target/spring-cloud-open-telemetry1-1.0.0-SNAPSHOT.jar spring-cloud-open-telemetry.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/spring-cloud-open-telemetry.jar"]