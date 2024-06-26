package onlineTest.Genesys.StepDefinitions;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;

public class Hooks {
  public  static Scenario scenario;

    @After
    public void afterScenario() {
        if(scenario.isFailed()) {
            System.out.println("Scenario Failed");
        }
    }

    @Before
    public void beforeScenario() {
        Hooks.scenario = scenario;
    }
}
