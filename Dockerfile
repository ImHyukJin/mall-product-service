# 기본 이미지로 OpenJDK 사용
FROM openjdk:11-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 파일을 컨테이너에 복사
COPY build/libs/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar /app/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar

# Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar"]

# 컨테이너가 외부와 통신할 포트 설정
EXPOSE 8081
