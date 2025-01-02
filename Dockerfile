FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN chmod +x ./mvnw
ENTRYPOINT ["java", "-jar", "/app.jar"]