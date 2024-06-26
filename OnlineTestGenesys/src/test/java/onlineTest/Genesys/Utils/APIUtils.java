package onlineTest.Genesys.Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APIUtils {
    public static Response response;
    public static RequestSpecification requestSpecification;

    public void setPathParam(String pathParam){
        requestSpecification=given().baseUri(baseURI).basePath(pathParam);
    }

    public void setQueryParam(String queryParam, String queryParamValue){
        requestSpecification=given().baseUri(baseURI).queryParams(queryParam,
                queryParamValue);
    }

    public Response postRequest(String requestBody){
        response=given().contentType(ContentType.JSON).body(requestBody).post();
        return response;
    }

    public Response getResponse(){
        response=requestSpecification.get();
        return response;
    }
}
