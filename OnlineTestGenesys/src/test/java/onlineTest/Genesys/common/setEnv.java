package onlineTest.Genesys.common;

import onlineTest.Genesys.Utils.PropertyReader;

import static onlineTest.Genesys.common.Constants.CONFIG_FILE;
import static io.restassured.RestAssured.baseURI;

public class setEnv {
    public static String environment;

    public void setEnvironment() {
        environment= PropertyReader.getProperty(CONFIG_FILE,"env");
        baseURI = PropertyReader.getProperty(CONFIG_FILE,environment);
    }
}
