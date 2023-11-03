
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/achat.jar
EXPOSE 5050
CMD ["java","-jar","/app/achat.jar"]
