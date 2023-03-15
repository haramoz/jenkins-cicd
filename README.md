# jenkins-cicd
Testing out Junit test cases with Jenkins CICD pipeline

## Dockerize
pom has a spring-boot-maven-plugin plugin configured which takes care of generating a runnable jar
added Dockerfile

To build & run the docker image:
<pre>docker image build -t docker-jenkins-java-jar:latest . </pre>
Here the snapshot will be repackaged and tagged docker-jenkins-java-jar (because of -t), . at the end signifies the location of the DOckerfile.

<pre> docker run docker-jenkins-java-jar:latest </pre>

### Jenkins Docker plugins
Installed Docker Pipeline. Manage Nodes and Clouds (under managa Jenkins) -> add a cloud -> added Docker there as cloud 

### Docker creds
I have a Docker Hub account, created new access token. Adding the creds in jenkins: 

Dashboard -> Manage Jenkins -> Credentials -> System -> Global credentials (unrestricted)

### Debugging Notes
Docker integration does not work out of the box.
Turns out that the jenkins uses Docker REST Api underneath and needs to be configured. Docker does not allow remote access by deafault and needs to be configured, like this worked.

https://stackoverflow.com/a/60728186/1578967

manage jenkins -> Configure System -> Docker Builder 
Tried the connection to tcp://127.0.0.1:2375 and test Connection worked
Hint: First the docker desktop has to be running and Docker engine is accessible via DD.

# Links 
https://www.jenkins.io/doc/book/installing/kubernetes/

https://phoenixnap.com/kb/how-to-configure-docker-in-jenkins