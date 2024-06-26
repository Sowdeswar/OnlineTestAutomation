package services;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonParser;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class createMessages {

    public static String id;
    public static String fromMessageName;
    public static String toMessageName;
    public static JSONObject messageResponseObj=new JSONObject();
    public static JSONObject fromid=new JSONObject();
    public static JSONObject toid=new JSONObject();

    public void getIDValueFromResponse(String attribute, Response response) {
        String responseBody = response.getBody().asString();
        Object responseBodyObj = null;
        try {
            responseBodyObj = new JSONParser().parse(responseBody);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        messageResponseObj=(JSONObject) responseBodyObj;
//        fromid =(JSONObject) messageResponseObj.get("from");
//        JSONObject fromObj=(JSONObject) fromid.get(0);
//        System.out.println("from id "+fromObj.get(attribute));
//        toid =(JSONObject) messageResponseObj.get("from");
//        JSONObject toObj=(JSONObject) toid.get(0);
//        System.out.println("to id "+toObj.get(attribute));
        id= messageResponseObj.get(attribute).toString();
        Assert.assertTrue("Response contains the id ",messageResponseObj.get(attribute).toString()!=null);
        System.out.println(id);
    }
}
