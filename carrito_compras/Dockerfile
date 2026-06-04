FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/carrito_compras-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_carrito
ENTRYPOINT ["java", "-jar", "app_carrito.jar"]