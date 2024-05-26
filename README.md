# Java Cucumber Test Automation Framework

This project contains automated tests for the SauceDemo website using Cucumber BDD with Java, Selenium, and JUnit. The tests cover the following functionalities:
- Authentication
- Products page
- Add to cart
- Checkout
- Burger Menu

## Project Structure
The project is structured as follows:
```
src
|-- main
| |-- java.com.saucedemo
| | |-- pages
| | | |-- BasePage.java
| | | |-- LoginPage.java
| | | |-- ProductsPage.java
| | | |-- CartPage.java
| | | |-- CheckoutPage.java
| | | |-- MenuPage.java
| | |-- utils
| | | |-- DriverManager.java
| | | |-- TestDataUtil.java
|-- test
| |-- java.com.saucedemo
| | |-- steps
| | | |-- AuthenticationSteps.java
| | | |-- ProductsPageSteps.java
| | | |-- CartSteps.java
| | | |-- CheckoutSteps.java
| | | |-- MenuSteps.java
| | |-- runners
| |-- RunCucumberTest.java
| |-- resources
| | |-- features
| | | |-- authentication.feature
| | | |-- products.feature
| | | |-- cart.feature
| | | |-- checkout.feature
| | | |-- menu.feature
| | |-- testData
| | | |-- credentials.json
pom.xml
readme.md
LICENSE
.gitignore
```

## Prerequisites
- Java 8 or higher
- Maven 3.6.3 or higher
- Chrome browser

## Setup
1. Clone the repository to your local machine: 
```git clone https://github.com/nikosthermo/java-cucumber-test-automation-framework.git```
2. Open the project in an IDE
3. Run the following command to install the dependencies:
```mvn clean install```
4. Run the following command to execute the tests:
```mvn test```
5. After the tests are executed, the reports will be generated in the target/cucumber-reports folder
6. Open the index.html file in the target/cucumber-reports folder to view the test results

## Test Data Management
Test data is managed using a JSON file (credentials.json) located in the src/test/resources/testData directory. 
The TestDataUtil class loads this data and provides access to it within the step definitions.

## Page Object Model
The project follows the Page Object Model (POM) design pattern. 
Each page of the website has a corresponding class in the com.saucedemo.pages package. 
These classes encapsulate the functionality and elements of the respective pages.

## Assumptions and Limitations
The tests assume that the website is accessible and stable.
The tests cover the basic functionalities specified and may not cover all edge cases.
Reporting is implemented using Cucumber's built-in report generation capabilities.
Test data is currently managed using a JSON file for simplicity.

## Contributing
If you would like to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new branch (git checkout -b feature/your-feature).
3. Make your changes and commit them (git commit -am 'Add some feature').
4. Push to the branch (git push origin feature/your-feature).
5. Create a new Pull Request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
