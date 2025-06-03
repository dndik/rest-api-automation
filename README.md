# RESTful API Test Automation Project

This project uses **Java**, **Cucumber**, **RestAssured**, and **Allure Reports** to perform automated testing on a sample RESTful API.

---

## Project Setup

1. **Unzip the Project**  
   Extract the project zip file to your preferred location.

2. **Import into IntelliJ IDEA**
    - Open IntelliJ IDEA
    - Go to `File > Open`
    - Select the unzipped project folder
    - IntelliJ will detect the `pom.xml` and import all Maven dependencies automatically

---

## Prerequisites

Make sure the following are installed:

- Java 11 or later
- Maven 3.6 or newer
- Allure CLI

**Install Allure CLI** (if not already installed):

- **Windows**:  
  Download from [https://github.com/allure-framework/allure2/releases](https://github.com/allure-framework/allure2/releases), extract, and add the `/bin` folder to your system `PATH`.

- **macOS (with Homebrew)**:
  ```bash
  brew install allure

- **Verify installation**:  
  `allure --version`

---

##  Building the Project

To build the project:

`mvn clean compile`

To build and run tests together:

`mvn clean install`

## Running the Tests

To run the tests run `mvn clean test` or run the TestRunner which is inside src/test/java/runner

This will:

- Execute feature file under `src/test/java/feature`
- Store shared test context (like object IDs and responses) across steps
- Generate Allure results in `allure-results`

## Generating and Viewing Allure Reports

`allure serve allure-results`

This command launches a temporary local server and opens the report in your default browser.
This can be done in command prompt if intellij is not detecting allure keyword

See img.png for my allure report screenshot


## Notes and Assumptions

- API base URL used: `https://api.restful-api.dev/objects`
- Test scenarios include object creation, retrieval, listing, and deletion
- `TestContext` is used to share data (like object ID) across steps within a scenario
- Allure results are generated automatically in `allure-results` upon test completion
- Be sure the `allure` command is recognized in your system's PATH before generating reports 


