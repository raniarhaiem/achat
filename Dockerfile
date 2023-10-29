FROM maven:3.3-jdk-8 as maven-build
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

From openjdk:8 \
copy --from=maven-build /usr/src/app/target/achat-1.0.jar achat-1.0.jar
CMD ["java","-jar","achat-1.0.jar"]