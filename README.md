# movies-api

## Subject
This project is a REST API in JAVA with Spring Boot. It permit to fetch a movie from another API (http://www.omdbapi.com) and save this one in the local database. We can get data from a movie saved in local database, update, and delete (CRUD operation).

## Technologies
- Java 12
- Spring boot 2.3.1
- MySQL database
- Maven

I chose a MySQL database because for our purposes that was enough. MySQL is very easy to install and to configure. 

## Install the requires 
To run this application, you need to install JAVA 12+, MySQL and Maven. 

### JAVA
Download link : https://www.oracle.com/fr/java/technologies/javase-downloads.html

### Mysql 
Installation tutorial :
- Windows : https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/windows-installation.html
- Mac : https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/osx-installation.html
- Linux : https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/linux-installation.html

### Maven
You have to install JAVA before install and configure maven. 
- Windows : https://mkyong.com/maven/how-to-install-maven-in-windows/
- Linux / MacOS : https://maven.apache.org/install.html

How to check if maven is correctly installed ?
Open a console and tap : 
```
mvn -v 
```

You should be able to see the current version : 
![alt text](https://zupimages.net/up/20/27/rgzk.png)

## Configure MySQL database
You have to configure your database MySQL access in a first time. To do this, you have to edit this file : 
```
src/main/resources/application.properties
```

You have to update this fields (url of your database, username and password) : 
```
spring.datasource.url=jdbc:mysql://localhost:3306/movies?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=mysqlpassword
```

If the database is not created, when you will the application, it will be created directly at running.

## Run the application 
You have to launch the following command in the projet root directory : 
```
mvn spring-boot:run
```

The server will run and you can access to the different request. 
```
http://localhost:8080/
```

## Rest API 
You can use a software like Postman to test the different url. 

Or you can use CURL command : 

- get all movies 
```
curl -v http://localhost:8080/movies
```
- post a new movie 
```
curl -d 'terminator' -H "Content-Type: application/json" http://localhost:8080/movies
```

- update a movie (change the {id} by a movie ID in database)
```
curl -d '{ "language" : "Français", "country" : "France" }' -H "Content-Type: application/json" -X PUT http://localhost:8080/movies/{id}
```

- delete a movie (change the {id} by a movie ID in database)
```
curl -X DELETE http://localhost:8080/movies/{id}
```

- post a comment (change the id movie in the body)
```
curl -d '{"comment" : "A very nice movie !","movie" : {"id" : {id} }}' -H "Content-Type: application/json" http://localhost:8080/comments/
```

- get all comments
```
 curl -v http://localhost:8080/comments
```

- get comments from a movie id (edit the {id} by the movieId)
```
curl -v http://localhost:8080/comments/?movieId={id}
```

- get the best movies by ranking and comments count. you have to choose the {start} and {end} date with this format : yyyy-MM-dd (example : 2020-06-31)
```
curl -v "http://localhost:8080/top?start={start}&end={end}"
```



