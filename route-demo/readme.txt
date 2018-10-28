demo project to create a rest webservice using spring boot, spring 4, java 8 and maven

This application creates a rest webservice which takes departure id and arrival id and responds with a json object telling if the direct route is available between the arrval station and departure station.
the route information is searched from a text file sitting inside the project area.
This application uses spring boot so there is no need for any explicit web server like tomcat to deploye the webservice.



maven version 3.3.9
java version 1.8.0_91
tested on windows 7

file path is read from application.properties file

use below command to run the webservice
mvn clean package spring-boot:run

hit the below url to get the rest API response in json format
http://localhost:8088/api/direct?dep_sid=1&arr_sid=3

cd test-training/jenkins
docker build -t naren-jenkins .
run -it -p 8080:8080 --name jenkins  -v $(pwd)/jobs:/var/jenkins_home/jobs -v /Users/narmandi/chaman:/var/nicktemp  naren-jenkins
# remove all containers
docker rm $(docker ps -a -q)


file system checkout jenkins docker
/var/nicktemp
cd kube-jenkins
docker build -t naren-jenkins-kube .
correct hostpath in j-d yaml
kubectl apply -f jenkins-deployment.yaml
