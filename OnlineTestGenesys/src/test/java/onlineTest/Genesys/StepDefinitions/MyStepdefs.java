package onlineTest.Genesys.StepDefinitions;

import io.qameta.allure.Allure;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import onlineTest.Genesys.Utils.APIUtils;
import onlineTest.Genesys.Utils.testDataReader;
import onlineTest.Genesys.common.sourcePayloadUpdate;
import onlineTest.Genesys.services.createUsers;
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
    createUsers createUsersObj = new createUsers();
    sourcePayloadUpdate sourcePayloadUpdateObj = new sourcePayloadUpdate();
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

    @When("user make a delete request to delete the message details by using id")
    public void userMakeADeleteRequestToDeleteTheMessageDetailsByUsingId() {
            setEnvObj.setEnvironment();
            apiUtilsObj.setPathParam(createMessages.id);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
            apiUtilsObj.deleteRequest();
    }

    @Given("input data to create users {string}")
    public void inputDataToCreateUsers(String sourcePayload) {
        testDataReader testDataReaderObj = new testDataReader();
        requestBody=testDataReaderObj.getData(sourcePayload);
        Allure.addAttachment("Request payload :: ", requestBody);
    }

    @And("user should receive the user id {string} in the response body")
    public void userShouldReceiveTheUserIdInTheResponseBody(String attributeId) {
        createUsersObj.getIDValueFromResponse(attributeId,APIUtils.response);
        Allure.addAttachment("Response body ::", prettyResponse);
    }

    @Given("input data to create messages {string} and {string}")
    public void inputDataToCreateMessagesAnd(String sourcePayload, String userType) {
        testDataReader testDataReaderObj = new testDataReader();
        requestBody=testDataReaderObj.getData(sourcePayload);
        sourcePayloadUpdateObj.updateSourcePayload(requestBody,userType);
        Allure.addAttachment("Request payload :: ", sourcePayloadUpdate.updatedRequestPayload);
    }

    @When("user make a create message post call")
    public void userMakeACreateMessagePostCall() {
        setEnvObj.setEnvironment();
        apiUtilsObj.postRequest(sourcePayloadUpdate.updatedRequestPayload);
        prettyResponse=APIUtils.response.asPrettyString();
        Allure.addAttachment("Post URL ::",baseURI);
    }

    @When("user make a get request to get the message details by using {string}")
    public void userMakeAGetRequestToGetTheMessageDetailsByUsing(String idType) {
            createMessagesObj.getMessageSetPathParam(idType);
            requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
            Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
            apiUtilsObj.getRequest();
    }

    @When("user make a update message put call")
    public void userMakeAUpdateMessagePutCall() {
            setEnvObj.setEnvironment();
            createMessagesObj.getMessageSetPathParam(createUsers.fromUser);
            apiUtilsObj.putRequest(sourcePayloadUpdate.updatedRequestPayload);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
    }

    @When("user make a get request to get the list of message details using fromuserid and touserid")
    public void userMakeAGetRequestToGetTheListOfMessageDetailsUsingFromuseridAndTouserid() {
        setEnvObj.setEnvironment();
        createMessagesObj.getMessageSetUpUsingQueryParam(createUsers.fromUser,createUsers.toUser);
        requestdetails= SpecificationQuerier.query(APIUtils.requestSpecification);
        Allure.addAttachment(" Request URL :: ",requestdetails.getURI());
        apiUtilsObj.getRequest();
    }
}
