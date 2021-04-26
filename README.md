# Usecase: 

Sample CSV file consists of details of users and the restaurant they visit frequently. This file consists of duplicate records which are validated on the backend for valid entries and unique elements are saved on to the database.

# User management service
Application using spring-boot to read a CSV to H2 database

Sample data csv file is included in src/main/resources. This can be used as test data for uploading from UI.

Steps to run this application using docker:

1> run <mvn install> to create the csv-to-db-0.0.1-SNAPSHOT.jar
2> Build the docker image: 
   run the command: <docker build -t csvtodb -f ./Dockerfile .>
3> Run the docker container with the above image using the command: 
   <docker run csvtodb>

Swagger UI 
------------
Swagger UI with documentation of the available APIs will be avaialble at localhost:8080/swagger-ui.html

APIs and URLs
-------------
Use the following URL to upload csv file: http://localhost:8080/upload

H2 database console
-------------------
This application is built using the H2 in memory database. Once the CSV file is uploaded, open h2 console which is available at : localhost:8080/h2-console

Make sure :
JDBC URL is jdbc:h2:mem:testdb
username: admin
password: password
