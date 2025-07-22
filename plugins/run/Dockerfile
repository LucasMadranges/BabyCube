FROM gradle:8.7.0-jdk21 AS builder

WORKDIR /app
COPY .. .
RUN gradle clean build --no-daemon

FROM eclipse-temurin:21-jre-alpine

WORKDIR /server

COPY --from=builder /run /run
COPY --from=builder /run/plugins /run/plugins

EXPOSE 25565

CMD ["java", "-Xms2G", "-Xmx2G", "-jar", "paper.jar", "--nogui"]