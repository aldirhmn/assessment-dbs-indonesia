# Selenium Java Automation with Cucumber

This repository contains a Selenium WebDriver automation framework using Java, Cucumber, and the Page Object Model (POM) pattern. It is designed to automate test cases for the login functionality of "The Internet" application, available at [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login).

## Folder Structure
        |-- src
        |   |-- main
        |   |   |-- java
        |   |   |   |-- pages
        |               |-- LoginPage.java
                    |-- utilities
                        |-- Helpers.java
        |   |   |-- resources
        |   |
        |   |-- test
        |       |-- java
        |           |-- runners
        |               |-- TestRunner.java
        |           |-- stepDefinitions
        |               |-- LoginSteps.java
        |           |-- ...
        |       |-- resources
        |           |-- features
        |               |-- Login
        |                   |-- LoginTest.feature
        |           |-- config
        |               |-- config.properties
        |           |-- drivers
        |               |-- chromedriver.exe
        |
        |-- .gitignore
        |-- pom.xml
        |-- README.md

## Features

- **Selenium WebDriver**: Automates browser actions and interactions.
- **Cucumber**: Supports behavior-driven development (BDD), allowing test specifications to be written in plain language.
- **Page Object Model**: Enhances test maintenance and reduces code duplication.
- **Configurable Properties**: Externalizes test configuration, making the tests adaptable to different environments without code changes.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Google Chrome or any browsers supported by Selenium

## Setup and Installation

1. **Clone the Repository**
   ```bash
   git clone github.com/aldirhmn/assessment-dbs-indonesia.git
   cd selenium-java-cucumber
2. **Install Depedencies**
   mvn clean install
4. **Configurations**
   
   Modify src/test/resources/config/config.properties to change the base URL or other parameters:
   ```bash
   baseUrl: http://the-internet.herokuapp.com/login
   ```

## Execute All Tests
1. To run all tests, execute the following command in your terminal:
```bash
mvn test
```

2. To run specific features or scenarios, use the Cucumber options:
```bash
mvn test -Dcucumber.options="--tags @LoginFunctionality"
```

## Reporting
   Test reports can be found in target/ directory after running the tests. For enhanced reporting, integrate with Cucumber reporting tools like Cucumber Reports.
   
## Contributing
   Contributions are welcome. Please fork the repository and submit a pull request.
