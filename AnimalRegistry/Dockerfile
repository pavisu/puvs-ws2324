# Build Stage
FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /opt/AnimalRegistry
COPY . .
RUN mvn clean package

# Final Stage
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt/AnimalRegistry
COPY --from=build /opt/AnimalRegistry/target/AnimalRegistry-0.0.1-SNAPSHOT.jar .
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

ENTRYPOINT ["java", "-javaagent:/opt/AnimalRegistry/opentelemetry-javaagent.jar", "-jar", "AnimalRegistry-0.0.1-SNAPSHOT.jar"]
CMD ["java","-jar", "-javaagent:opentelemetry-javaagent.jar" ,"app.jar"]