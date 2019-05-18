FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD wordladder_function-1.0-SNAPSHOT.jar app.jar
ADD dictionary.txt dictionary.txt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080