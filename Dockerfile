FROM bitnami/java:17

ARG DESCRIPTION=""

LABEL org.opencontainers.image.description $DESCRIPTION

EXPOSE 8080

WORKDIR /app

COPY /build/libs/demo-rest-0.0.1-SNAPSHOT.jar /app/demo-rest-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./demo-rest-0.0.1-SNAPSHOT.jar"]
