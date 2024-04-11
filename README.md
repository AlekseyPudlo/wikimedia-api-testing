# Wikimedia API Testing Project
This project contains automated test cases for the Wikimedia search API, focusing on specific scenarios involving searches and page details verification. It uses Java, JUnit 5, and Rest Assured for API testing.

## Prerequisites

What things you need to install the software and how to install them:

- Java JDK 11 or newer
- Maven 3.6.3 or newer

## Installing

A step by step series of examples that tell you how to get a development environment running:

1. Clone the repository to your local machine:
`git clone git@github.com:AlekseyPudlo/Wikimedia-API-Testing.git`.


2. Navigate to the project directory:
`cd wikimedia-api-testing`.


3. Use Maven to install dependencies and build the project:
`mvn clean install`.
This will download all the necessary dependencies and compile the test classes.

## Running Tests

To run the automated tests for this project, you can use the following command from the project root:
`mvn test`.
This command will execute all tests in the project and provide a summary of the test executions, including any failures or errors.

## Test Scenarios

- **Scenario 1**: Search for 'furry rabbits' and verify that the search results contain a page titled 'Sesame Street'.
- **Scenario 2**: Given the search result contains 'Sesame Street', verify that the page details have a latest revision timestamp greater than 2023-08-17.

## Authors

- **Oleksii Pudlo** - *Initial work* - [GitHub](https://github.com/AlekseyPudlo)







