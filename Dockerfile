FROM eclipse-temurin:21-jdk-alpine as builder

WORKDIR /app

COPY . .

RUN  sh ./gradlew bootJar

FROM eclipse-temurin:21-jre-alpine as runner
ARG JARFILE=*.jar
COPY --from=builder /app/build/libs/${JARFILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]