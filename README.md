# Sample Testing Application

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

### Rules to be applied for this application
This application should follow the rules: 
1. A User with 30 years or more should only be allowed to pay with credit card
2. All user must have a Name with 30 positions at most, age with two positions at most
3. All user must have only one payment method  
4. A User with less  than 30 years can pay with BillingSlip and Credit Card
5. Given a valid user, it should be stored for latter use (consulting for example)

## What should I do if I have a doubt and is not clear here?
- Ask :) Let's discuss and then improve this documentation together.

##### Gateway Controller responsibilities:
1. Should define the correct rest verb:<br/>
  GET --> Retrieving elements.<br/>
  PUT --> Updating an existing element<br/>
  POST --> Create a new element<br/>
  POST --> Can also be used to retrieve data with a @RequestBody (sometimes a complex consuting may need to pass a Body. Since Get doesn't accept body, use Post for convention)<br/>
  PATCH --> To partially update of an Element<br/>
  DELETE --> To remove one element<br/>
2. Should perform Bean Validation of the incoming Payload
3. Should Convert the incoming payload for a Domain object and pass the domain object to the usecase for processing
4. Should document with Swagger all the service (input, output and possible error codes)
5. Should NOT have access to other gateways.
6. Should be unit tested using JUnit, Mockito and MockMVC
7. Depending of the exposed service, it may need to configure security
8. May log (beware for sensitive data) the incoming payload
9. Should always convert the Domain object returned from the usecase execution to a new object (json/data contract)
10. Always return one ResponseEntity wrapping the response object (json/data contract)
11. Should define the consumed and produced data accepted (produces/consumes)

##### usecase responsibilities:
1. May log (beware for sensitive data) the incoming payload
2. Should perform business rules and validations
3. May use another usecase(s) (through constructor injection)
4. May use 1 or more Gateways (through constructor injection using ALWAYS an interface and never the concrete implementation)
5. Should be EXTENSIVELY tested with Spock testing framework

##### Other hints 
1. Always check the existence of a Controller Advice to handle possible exceptions thrown from the usecase