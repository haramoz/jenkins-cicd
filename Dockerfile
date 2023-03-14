FROM openjdk:11
COPY target/jenkins-cicd-1.0-SNAPSHOT-REPACKED.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]