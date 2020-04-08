FROM maven:3.3-jdk-8 AS build
LABEL name=tthv3
LABEL version=0.0.1

COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app
COPY settings.xml /usr/src/app
ENV GITHUB_USERNAME = $_GITHUB_USERNAME
ENV GITHUB_TOKEN = $_GITHUB_TOKEN 
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8
# copy any jar files into the image
COPY --from=build /usr/src/app/target/*.jar /usr/app/tthv3.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/app/tthv3.jar"]
