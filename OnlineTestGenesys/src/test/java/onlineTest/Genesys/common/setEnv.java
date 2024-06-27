package onlineTest.Genesys.common;

import onlineTest.Genesys.Utils.PropertyReader;

import java.util.Properties;

import static onlineTest.Genesys.StepDefinitions.Hooks.scenarioName;
import static onlineTest.Genesys.common.Constants.CONFIG_FILE;
import static io.restassured.RestAssured.baseURI;

public class setEnv {
    public static String environment;
public static String baseURL;
    public void setEnvironment() {
        environment= PropertyReader.getProperty(CONFIG_FILE,"env");
        baseURL = PropertyReader.getProperty(CONFIG_FILE,environment);
        if(scenarioName.contains("Creating the users")){
            baseURI=baseURL+PropertyReader.getProperty(CONFIG_FILE,"Create_User");
        }
        else if(scenarioName.contains("create messages")){
            baseURI=baseURL+PropertyReader.getProperty(CONFIG_FILE,"Create_Message");
        }
    }
}
