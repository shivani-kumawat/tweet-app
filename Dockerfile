FROM openjdk:13-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/TweetApplication-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} TweetApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/TweetApplication-0.0.1-SNAPSHOT.jar"]