maven version 3.3.9
java version 1.8.0_91

file path is read from application.properties file

use below command to run the webservice
mvn clean package spring-boot:run

hit the below url to get the rest API response in json format
http://localhost:8088/api/direct?dep_sid=1&arr_sid=3