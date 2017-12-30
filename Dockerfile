FROM frolvlad/alpine-oraclejdk8:slim

ENV SERVER_PORT 39080
EXPOSE $SERVER_PORT

COPY target/spring-boot-embedded-tomcat-and-database-0.0.1-SNAPSHOT.jar /

CMD [ "java", "-jar", "/spring-boot-embedded-tomcat-and-database-0.0.1-SNAPSHOT.jar" ]
