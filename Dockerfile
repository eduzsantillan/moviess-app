FROM openjdk:17-alpine
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} movies-1.0.1.jar
ENTRYPOINT ["java","-jar","/movies-1.0.1.jar"]
