FROM openjdk:11

#FROM adoptopenjdk/openjdk11:alpine-jre
# Refer to Maven build -> finalName
ARG JAR_FILE=target/spring-web-jpa.war
# cd /opt/app
WORKDIR /opt/app
# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} spring-web-jpa.war
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","spring-web-jpa.war"]

#sudo docker run -d -p 8081:8081 -t spring-web-h2:1
#sudo docker build -t spring-web-h2:1 .