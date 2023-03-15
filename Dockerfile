FROM openjdk:11
COPY target/jenkins-cicd-1.0-snapshot-repacked.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080