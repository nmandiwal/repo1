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