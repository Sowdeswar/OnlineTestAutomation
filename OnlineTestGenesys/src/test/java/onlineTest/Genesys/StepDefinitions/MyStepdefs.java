package onlineTest.Genesys.StepDefinitions;

import io.qameta.allure.Allure;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import onlineTest.Genesys.Utils.APIUtils;
import onlineTest.Genesys.Utils.testDataReader;
import onlineTest.Genesys.common.setEnv;
import onlineTest.Genesys.common.validation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onlineTest.Genesys.services.createMessages;

import static io.restassured.RestAssured.baseURI;

public class MyStepdefs {
    public String requestBody;
    public String prettyResponse;
    APIUtils apiUtilsObj = new APIUtils();
    setEnv setEnvObj = new setEnv();
    validation validationObj = new validation();
    createMessages createMessagesObj = new createMessages();
    QueryableRequestSpecification requestdetails;

        @Given("input data to create messages {string}")
        public void input_data_to_create_messages(String sourcePayload) {
            testDataReader testDataReaderObj = new testDataReader();
            requestBody=testDataReaderObj.getData(sourcePayload);
            Allure.addAttachment("Request payload :: ", requestBody);
        }

        @When("user make a post call")
        public void user_make_a_post_call() {
            setEnvObj.setEnvironment();
            apiUtilsObj.postRequest(requestBody);
            prettyResponse=APIUtils.response.asPrettyString();
            Allure.addAttachment("Post URL ::",baseURI);
        }

        @Then("user should receive the {int}")
        public void user_should_receive_the(Integer statusCode) {
            validationObj.validateStatusCode(statusCode);
            Allure.addAttachment("Status Code ::", String.valueOf(APIUtils.response.getStatusCode()));
        }

        @And("user should receive the {string} in the response body")
        public void user_should_receive_the_in_the_response_body(String attributeId) {
            createMessagesObj.getIDValueFromResponse(attributeId,APIUtils.response);
            Allure.addAttachment("Response body ::", prettyResponse);
        }

    @When("user make a get request to get the message details by using id")
    public void userMakeAGetRequestToGetTheMessageDetailsByUsingId() {
        setEnvObj.setEnvironment();
        apiUtilsObj.setPathParam(createMessages.id);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
        apiUtilsObj.getRequest();
        prettyResponse=APIUtils.response.asPrettyString();
    }

    @Then("user should receive the <{int}>")
    public void userShouldReceiveThe(int statusCode) {
            validationObj.validateStatusCode(statusCode);
            Allure.addAttachment("Status Code ::", String.valueOf(statusCode));
    }

    @When("user make a get request to get the list of message details {string} {string}")
    public void userMakeAGetRequestToGetTheListOfMessageDetails(String from, String to) {
        setEnvObj.setEnvironment();
        createMessagesObj.getMessageSetUpUsingQueryParam(from,to);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
        apiUtilsObj.getRequest();
    }



    @When("user make a delete request to delete the message details by using id")
    public void userMakeADeleteRequestToDeleteTheMessageDetailsByUsingId() {
            setEnvObj.setEnvironment();
            apiUtilsObj.setPathParam(createMessages.id);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
            apiUtilsObj.deleteRequest();
    }
}
