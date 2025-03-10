# 기본 이미지로 OpenJDK 사용
FROM openjdk:11-jdk-slim

ARG JAR_FILE=build/libs/*.jar
ARG PROFILES
ARG ENV

# 빌드된 JAR 파일을 컨테이너에 복사
COPY ${JAR_FILE} app.jar

# Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILES}", "-Dserver.env=${ENV}","-jar","app.jar"]

