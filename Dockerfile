FROM openjdk:8
ADD target/csv-to-db-0.0.1-SNAPSHOT csv-to-db.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","csv-to-db.jar"]