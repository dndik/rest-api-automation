package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepdefs", "runner"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = ""
)


public class TestRunner extends AbstractTestNGCucumberTests {

}
