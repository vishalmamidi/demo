FROM openjdk:17-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY /build/libs/demo-rest-0.0.1-SNAPSHOT.jar /app/demo-rest-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./demo-rest-0.0.1-SNAPSHOT.jar"]
