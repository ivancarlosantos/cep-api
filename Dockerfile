FROM maven:3.8.5-openjdk-11-slim AS build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:11
LABEL key="core.api.ics.cep-api"
EXPOSE 9090
ARG JAR_FILE=target/*.jar
ADD target/cep-api.jar cep-api.jar
COPY ${JAR_FILE} cep-api.jar
CMD [ "java", "-jar", "cep-api.jar" ]

 

