# jenkins-cicd
Testing out Junit test cases with Jenkins CICD pipeline

## Dockerize
pom has a spring-boot-maven-plugin plugin configured which takes care of generating a runnable jar
added Dockerfile

To build & run the docker image:
<pre>docker image build -t docker-jenkins-java-jar:latest . </pre>
Here the snapshot will be repackaged and tagged docker-jenkins-java-jar (because of -t), . at the end signifies the location of the DOckerfile.

<pre> docker run docker-jenkins-java-jar:latest </pre>

### Docker creds
I have a Docker Hub account, created new access token. Adding the creds in jenkins: 

Dashboard -> Manage Jenkins -> Credentials -> System -> Global credentials (unrestricted)


# Links 
https://www.jenkins.io/doc/book/installing/kubernetes/
