FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/ventas-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_ventas.jar
ENTRYPOINT ["java", "-jar", "app_ventas.jar"]