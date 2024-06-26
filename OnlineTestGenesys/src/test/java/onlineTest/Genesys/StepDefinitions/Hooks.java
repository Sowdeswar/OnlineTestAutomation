package onlineTest.Genesys.StepDefinitions;

public class Hooks {
  public  static Scenario scenario;

    @After
    public void afterScenario() {
        if(scenario.isFailed()) {
            System.out.println("Scenario Failed");
        }
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Hooks.scenario = scenario;
    }
}
