# CronExpressionGenerator
- This Repository consist of a project named as CronExpressionGenerator that contains all the webservices needed for generating cron expression for cron jobs.Generated expressions are based on Quartz cron format.

## Technology stack
The project is based on a web service called REST,which uses the following technologies:

#### Backend
Java 1.8
Spring boot
RESTful Web services
Maven
#### Application Server
Tomcat
#### Development Tool
Spring Tool Suit(STS)
#### Testing Tool
Postman Api

#### Architecture
The architecture of the web service is built with the following components:
- Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
- DataTransferObjects: Objects which are used for outside communication via the API.
- Service: Implements the business logic and handles the generation of cron expression.

#### How to use the application
You should be able to start the application by executing CronExpressionGeneratorApplication(A java Class),which starts a webserver on port 8080 (http://localhost:8080).

 You can use these webservices for generating cron expression according to your need.
 
 You can use the below cronMaker application to verify your cron expression,I also created these webservices by the help of the below given application.
##### [CronMaker](http://www.cronmaker.com/;jsessionid=node061q9kt7um7hq1jpxqp2hr24de1241044.node0?0 "CronMaker")
You can test these webservices through Postman(A testing tool for testing Rest based webservices).






