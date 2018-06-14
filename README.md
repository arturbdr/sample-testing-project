# Sample Testing Application
#### The purpose of this application is to show how to develop one application following:
- Unit tests with JUnit and Mockito for **controllers** and **gateway** layers
- BDD tests with Spock for **usecase** layer
- JaCoCo to validate and check testing code coverage
- Formatting code with Google Style guide
- Checking code good practices with SonarQube local and with Intellij plugin
- Checking code good practices with FindBugs using Intellij plugin 
- Executing Mutation test 


### Rules to be applied for this application
This application should receive 
1. A User with 30 years or more should only be allowed to pay with credit card
2. A User with less  than 30 years can pay with BillingSlip and Credit Card
3. Only Users from Brazil will 