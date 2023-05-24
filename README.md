# Swagger generated server

Spring Boot application for brokers, who will sell policies for bicycles.


## Overview  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  



## **Getting Started**

To get started with the application, you can follow these steps:

1.  Clone the repository to your local machine: **git clone https://github.com/Ashipka/bicycle-insurance-service.git**
2.  Navigate to the project directory: **cd bicycle-insurance-service**
3.  Build the project using Maven: **mvn clean install**
4.  Run the application: **java -jar .\bicycle-insurance-service-1.0.0.jar**

The application should now be running on port 8080.

## **Usage**

To use the application, you can use **swagger** 

## **Upgrade**
Application is used to process three type of risk types: DAMAGE, THEFT, THIRD_PARTY_DAMAGE.

When we need add more risk types we just copy/paste/rename TemplateInsuranceSumRule.groovy and TemplatePremiumRule.groovy.
Implement calculation logic inside these files.

## **Testing**

To run the unit tests for the application, you can use the following command:

`mvn test`

This will run all the JUnit tests in the project.

## **Contributing**

If you'd like to contribute to the project, feel free to fork the repository and submit a pull request.
