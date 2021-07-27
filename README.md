# CronExpressionGenerator
- This Repository consist of a project named as CronExpressionGenerator that contains all the webservices needed for generating cron expression for cron jobs.Generated expressions are based on Quartz cron format.

## Technology stack
The project is based on a web service called REST,which uses the following technologies:

#### Backend
- Java 1.8
- Spring boot
- RESTful Web services
- Maven
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

##### Expression from CronMaker Application(for Minutes)

![image](https://user-images.githubusercontent.com/49890059/127139114-1c863750-7396-4ed9-b0c8-f9d1863c30f5.png)

##### Expression from CronExpressionGenerator webservice(for Minutes)

![image](https://user-images.githubusercontent.com/49890059/127139384-e37f8dcf-1067-44f0-8c95-eb1cd2fc76f4.png)

##### Expression from CronMaker Application(for Hour 1st Radio Button Every)

![image](https://user-images.githubusercontent.com/49890059/127140148-661b29bc-9eb3-44c9-bab0-15f6e969c393.png)


##### Expression from CronExpressionGenerator webservice(for Hour 1st Radio Button Every)

![image](https://user-images.githubusercontent.com/49890059/127140234-cf5c2823-9631-46ed-9a2f-e37df624c687.png)

###### For Hour on 2nd radio StartAt

###### CronMakerpplication
![image](https://user-images.githubusercontent.com/49890059/127140579-15b2e594-724e-4d9a-9316-855f7db1f91f.png)

###### CronExpressionGenerator
![image](https://user-images.githubusercontent.com/49890059/127140633-3c6522f1-26a9-4641-968f-8e1dd064486a.png)

- As above screenshot are for reference purpose,you can test and verify like that.
