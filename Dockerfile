# �⺻ �̹����� OpenJDK ���
FROM openjdk:11-jdk-slim

# �۾� ���丮 ����
WORKDIR /app

# ����� JAR ������ �����̳ʿ� ����
COPY build/libs/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar /app/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar

# Spring Boot ���ø����̼� ����
ENTRYPOINT ["java", "-jar", "/app/MALL_PRODUCT_SERVICE-0.0.1-SNAPSHOT.jar"]

# �����̳ʰ� �ܺο� ����� ��Ʈ ����
EXPOSE 8081
