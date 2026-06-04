FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/productos_service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_productos.jar
ENTRYPOINT ["java", "-jar", "app_productos.jar"]