# jukinMedia
Jukin Media Assessment Project

This is a simple Java /JPA/Hibernate /Maven/ Spring Boot application that can be used as a starter for creating a REST web services complete.
This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary.

How to run the code.

Please follow the below instructions for your referenece.

1. Import this spring boot project under maven project into eclipse.
2. Wait till all the dependencies downloaded maven repository. if not then goto to the folder location where pom.xml exists and type cmd into the directory location
on the top and do the mvn clean install.
3. Open application.properties file for the DB configuration. I have used mySQL DB and the schema name is jukinMedia. Please enter your username and Password. 
4. Open src/main/java/com/jukinmedia/service/covidapp/CovidAppApplication.java java file and right click on goto Run As --> Java Application
    Once the application runs you should see something like this
    
2021-06-22 13:19:36.043  INFO 11290 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-06-22 13:19:36.055  INFO 11290 --- [  restartedMain] c.j.s.covidapp.CovidAppApplication       : Started CovidAppApplication in 9.906 seconds (JVM running for 11.09)


5. keep monitoring the console for the port by default it is 8080.

6. Kindly use Postman API client and below are the custom url for consuming web serives.
  A. http://localhost:8080/api/covid/covidCountry/format/{format}/countryName/{countryName}
  B. http://localhost:8080/api/covid/covidCountry/format/{format}/countryCode/{countryCode}
  C. http://localhost:8080/api/covid/listOfCovidRecords
  D. http://localhost:8080/api/covid/totalRecords
  
JUnit and Integaration Testing.

For JUnit - CovidAppApplicationTests.java
For Integaration - CovidAppApplicationIntegrationTest.java

