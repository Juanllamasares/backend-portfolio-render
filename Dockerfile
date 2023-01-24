FROM amazoncorretto-alpine-jdk
MAINTAINER JELL
COPY target/jell-0.0.1-SNAPSHOT.jar  jell-app.jar
ENTRYPOINT ["java","-jar","/jell-app.jar"]