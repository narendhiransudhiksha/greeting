FROM openjdk:8
VOLUME /tmp
COPY target/docker-spring-greeting-v1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]