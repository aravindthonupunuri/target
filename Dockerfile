FROM openjdk:8-jre-alpine
WORKDIR /usr/src/app/target
COPY build/libs/*.jar .
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /usr/src/app/target/*.jar"]