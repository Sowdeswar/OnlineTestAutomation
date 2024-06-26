package onlineTest.Genesys.testRunners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                glue="onlineTest.Genesys.StepDefinitions",
                plugin={"json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner {

}
