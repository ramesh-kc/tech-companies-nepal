FROM openjdk:8-jdk-alpine
ADD target/tech-companies-nepal.jar tech-companies-nepal.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "tech-companies-nepal.jar"]