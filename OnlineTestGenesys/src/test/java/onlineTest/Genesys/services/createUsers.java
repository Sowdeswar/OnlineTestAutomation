package onlineTest.Genesys.services;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class createUsers {
    public static String fromUser=null;
    public static String toUser=null;
    public static JSONObject messageResponseObj=new JSONObject();

    public void getIDValueFromResponse(String attribute, Response response) {
        String responseBody = response.getBody().asString();
        Object responseBodyObj = null;
        try {
            responseBodyObj = new JSONParser().parse(responseBody);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        messageResponseObj=(JSONObject) responseBodyObj;
        if(fromUser==null){
            fromUser=messageResponseObj.get(attribute).toString();
        }else {
            toUser=messageResponseObj.get(attribute).toString();
        }
        Assert.assertTrue("Response contains the id ",messageResponseObj.get(attribute).toString()!=null);
    }
}
