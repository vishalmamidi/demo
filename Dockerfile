

FROM gradle:7.3.3-jdk11 AS builder

COPY --chown=gradle:gradle . .

EXPOSE 8080

WORKDIR /app

COPY ./build/libs/demo-rest-0.0.1-SNAPSHOT.jar ./app/demo-rest-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./demo-rest-0.0.1-SNAPSHOT.jar"]