FROM eclipse-temurin:17-jre

WORKDIR /app

# Spring Boot application
COPY target/*.jar keyclock.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","keyclock.jar"]