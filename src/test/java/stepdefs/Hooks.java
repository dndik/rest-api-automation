package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.utils.RequestBuilder;
import org.example.utils.TestContext;
import org.testng.annotations.AfterSuite;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        RequestBuilder.init();
        RequestBuilder.setFilters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("cleanup after suite run");
        TestContext.clear();
    }

}
