# Stage 1: Build the JAR file using Maven
FROM maven:3.3-jdk-8 as maven-build
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

# Stage 2: Create the final image with the JAR file
FROM openjdk:8
EXPOSE 8082
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=maven-build /usr/src/app/target/achat-1.0.jar achat-1.0.jar

ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]

