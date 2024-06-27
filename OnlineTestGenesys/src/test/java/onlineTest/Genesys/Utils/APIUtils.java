package onlineTest.Genesys.Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIUtils {
    public static Response response;
    public static RequestSpecification requestSpecification;

    public void setPathParam(String pathParam){
        requestSpecification=given().baseUri(baseURI).basePath(pathParam);
    }

    public void setQueryParam(Map<String,Object> queryParam){
        requestSpecification=given().baseUri(baseURI).queryParams(queryParam);
    }

    public Response postRequest(String requestBody){
        response=given().contentType(ContentType.JSON).body(requestBody).post();
        return response;
    }

    public Response putRequest(String requestBody){
        response=requestSpecification.contentType(ContentType.JSON).body(requestBody).put();
        return response;
    }

    public Response getRequest(){
        response=requestSpecification.get();
        return response;
    }

    public Response deleteRequest(){
        response =requestSpecification.delete();
        return response;
    }
}
