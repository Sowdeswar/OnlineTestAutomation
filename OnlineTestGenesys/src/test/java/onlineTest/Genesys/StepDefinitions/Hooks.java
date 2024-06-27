package onlineTest.Genesys.StepDefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  public  static Scenario scenario;
  public static String scenarioName;

    @Before
    public void beforeScenario(Scenario scenario) {
       // Hooks.scenario = scenario;
        scenarioName=scenario.getName();
        System.out.println(scenarioName);
    }
}
