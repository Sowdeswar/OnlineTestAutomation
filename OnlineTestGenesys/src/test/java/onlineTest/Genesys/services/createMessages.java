package onlineTest.Genesys.services;

import io.restassured.response.Response;
import onlineTest.Genesys.Utils.APIUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class createMessages {

    public static String id;
    public static String fromMessageName;
    public static String toMessageName;
    public static JSONObject messageResponseObj=new JSONObject();
    public static JSONObject fromid=new JSONObject();
    public static JSONObject toid=new JSONObject();
    Map<String , Object> queryParamMap=new HashMap<String , Object>();

    APIUtils apiUtilsObj=new APIUtils();

    public  void getMessageSetUpUsingQueryParam(String from,String to){
        if(!queryParamMap.isEmpty())
            queryParamMap.clear();
        queryParamMap.put("from",from);
        queryParamMap.put("to",to);
        apiUtilsObj.setQueryParam(queryParamMap);

    }

    public void getIDValueFromResponse(String attribute, Response response) {
        String responseBody = response.getBody().asString();
        Object responseBodyObj = null;
        try {
            responseBodyObj = new JSONParser().parse(responseBody);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        messageResponseObj=(JSONObject) responseBodyObj;
        id= messageResponseObj.get(attribute).toString();
        Assert.assertTrue("Response contains the id ",messageResponseObj.get(attribute).toString()!=null);
        System.out.println(id);
    }
}
