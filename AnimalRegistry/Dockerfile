FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
COPY target/*.jar app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"
ENTRYPOINT ["java","-jar","/app.jar"]