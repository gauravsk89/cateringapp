FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=web.module/target/web.module-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]