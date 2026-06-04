FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/eureka-sv-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_eureka_sv
ENTRYPOINT ["java", "-jar", "app_eureka_sv.jar"]