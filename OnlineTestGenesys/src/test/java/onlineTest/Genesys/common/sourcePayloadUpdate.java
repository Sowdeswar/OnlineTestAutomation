package onlineTest.Genesys.common;

import onlineTest.Genesys.services.createUsers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class sourcePayloadUpdate {
    public static String updatedRequestPayload;
    public static JSONObject requestBodyObj=new JSONObject();

    public void updateSourcePayload(String requestBody,String attribute){
        Object Obj = null;
        try {
           Obj = new JSONParser().parse(requestBody);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        requestBodyObj=(JSONObject) Obj;

        if(attribute.equals("createMessage")){
            JSONObject fromObj;
            JSONObject toObj;
            fromObj = (JSONObject) ((JSONObject) requestBodyObj).get("from");
            toObj = (JSONObject) ((JSONObject) requestBodyObj).get("to");
            fromObj.put("id",createUsers.fromUser);
            toObj.put("id",createUsers.toUser);
            requestBodyObj.put("from",fromObj);
            requestBodyObj.put("to",toObj);
            updatedRequestPayload=requestBodyObj.toString();
        }
        else if(attribute.equals("Valid")) {
            requestBodyObj.put("name","updatedTestUser");
            requestBodyObj.put("id",createUsers.fromUser);
            updatedRequestPayload=requestBodyObj.toString();
        }
        else if(attribute.equals("InValid")) {
            requestBodyObj.remove("id");
            updatedRequestPayload=requestBodyObj.toString();
        }
    }
}
