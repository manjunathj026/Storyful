# Storyful Signup Form Test Suite

This project contains a test suite for the Storyful signup form. The tests are written using Selenium WebDriver and Cucumber, and the project is set up in Eclipse.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 8 or higher)
- Maven installed
- Eclipse IDE installed
- ChromeDriver executable in your system's PATH (or the path to your specific WebDriver(eg: Chrome,Firefox etc.,))
- Google Chrome browser installed
- Cucumber installed
- Junit installed
- All the necessarru dependencies given in the pom.xml file should be installed.

## Project Structure

The project follows the standard Maven structure and contains the following directories and files:

├── pom.xml
├── src
│ ├── main
│ │ └── java
│ │ └── com
│ │ └── storyful
│ │ └── signup
│ │ └── helpers
│ ├── test
│ │ ├── java
│ │ │ └── com
│ │ │ └── storyful
│ │ │ └── signup
│ │ │ ├── runners
│ │ │ └── steps
│ │ └── resources
│ │ └── features
│ │ └── AutoLoginPage.feature
└── README.md



## Running Tests

To run the tests, follow these steps:

1. **Run from Eclipse**:
    - Right-click on the `TestRunner.java` class located in `Cucumber_Test_Project/src/test/java/runner/TestRunner.java`
    - Select `Run As > JUnit Test`
