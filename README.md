# Sample Testing Application

[![Build Status](https://travis-ci.org/arturbdr/sample-testing-project.svg?branch=master)](https://travis-ci.org/arturbdr/sample-testing-project)
[![codecov](https://codecov.io/gh/arturbdr/sample-testing-project/branch/master/graph/badge.svg)](https://codecov.io/gh/arturbdr/sample-testing-project)
[![sonarCloudBugs](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=bugs)](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=bugs)
[![sonarCloudCodeSmell](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=code_smells)](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=code_smells)
[![sonarCloudTechnicalDebit](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=sqale_index)](https://sonarcloud.io/api/project_badges/measure?project=com.example%3Asample-testing-project&metric=sqale_index)
#### The purpose of this application is to show how to develop one application with:

- Clean Architecture
- Unit tests with JUnit and Mockito for **http** and **gateway** layers
- BDD tests with Spock for **usecase** layer
- JaCoCo to validate and check testing code coverage
- Formatting code with Google Style guide inside IDE
- Checking code good practices with SonarQube using with Intellij plugin
- Checking code good practices with FindBugs using Intellij plugin 
- Executing Mutation test 
- Checking all together submitting the application locally to SonarQube
- Handling Exceptions

### Rules to be applied for this application - Exercises
This application should follow the rules: 
1. A User must have more than 30 years
2. A user cant be created without a name, age and CPF
3. The username size must be at least 2 and start with letter Z.
4. Given a valid user, it should be stored for latter use


### Rules to be applied for this application - more Exercises
1. There should be a way to update a user
2. There can be more than one user with same CPF
3. When updating an user, the same rules of creations applies.

## What should I do if I have a doubt and is not clear here?
- Ask :) Let's discuss and then improve this documentation together.

#### Gateway Controller responsibilities:
1. Must define the correct rest verb:<br/>
  GET --> Retrieving elements.<br/>
  PUT --> Updating an existing element<br/>
  POST --> Create a new element<br/>
  POST --> Can also be used to retrieve data with a @RequestBody (sometimes a complex consuting may need to pass a Body. Since Get doesn't accept body, use Post for convention)<br/>
  PATCH --> To partially update of an Element<br/>
  DELETE --> To remove one element<br/>
2. Must perform Bean Validation of the incoming Payload (Json/DataContract object)
3. After validate the incoming payload, **Must** Convert the incoming payload for a Domain object and pass the domain object to the usecase for processing
4. Must document with Swagger all the services (input, output and possible error codes)
5. Must **NOT** have access to other gateways.
6. Must be unit tested using JUnit, Mockito and MockMVC
7. Depending of the exposed service, it may need to configure security
8. May log (**beware for sensitive data**) the incoming payload
9. Must always convert the Domain object returned from the usecase execution to a new object (json/data contract)
10. Always return one ResponseEntity wrapping the response object (json/data contract) along with the correct status code (200, 201, 404, 500 etc)
11. Must define the consumed and produced data accepted (produces/consumes annotations)
12. Depending on the data volume, work with pagination

#### Usecase responsibilities:
1. May log (beware for sensitive data) the incoming payload
2. Must perform business rules and validations
3. May use another usecase(s) (through constructor injection)
4. May use 1 or more Gateways (through constructor injection using ALWAYS an interface and never the concrete implementation)
5. Must be EXTENSIVELY tested with Spock testing framework
6. Must be responsible for a single operation (for example: CreateUser, PayOrder, ReturnOrder)
7. Must have only ONE public method

##### Other hints and site references
1. Always check the existence of a Controller Advice to handle possible exceptions thrown from the usecase or other layers of the code (the client should not never receive unpredicted exceptions)
2. Always check the spring boot doc at: [Spring Boot 1.5.8 reference guide](https://docs.spring.io/spring-boot/docs/1.5.8.RELEASE/reference//htmlsingle)
3. In case of legacy code, check this website with good refactoring strategies and practice exercises: [Refactoring](https://sourcemaking.com/refactoring)
4. Reference site of "Uncle Bob - Robert Martin": [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)
5. Testing Strategies in microservices: [Testing Strategies](https://martinfowler.com/articles/microservice-testing/) 
