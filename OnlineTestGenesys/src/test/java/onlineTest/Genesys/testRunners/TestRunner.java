package onlineTest.Genesys.testRunners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                glue="onlineTest.Genesys.StepDefinitions",
                tags="@CreateUser or @CreateMessage",
                plugin={"pretty", "html:target/cucumber-report","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class TestRunner {

}
