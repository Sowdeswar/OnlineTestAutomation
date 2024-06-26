package onlineTest.Genesys.StepDefinitions;

import onlineTest.Genesys.Utils.APIUtils;
import onlineTest.Genesys.Utils.testDataReader;
import onlineTest.Genesys.common.setEnv;
import onlineTest.Genesys.common.validation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.createMessages;

public class MyStepdefs {
    public String requestBody;
    public String prettyResponse;
APIUtils apiUtilsObj = new APIUtils();
setEnv setEnvObj = new setEnv();
validation validationObj = new validation();
createMessages createMessagesObj = new createMessages();

        @Given("input data to create messages {string}")
        public void input_data_to_create_messages(String sourcePayload) {
testDataReader testDataReaderObj = new testDataReader();
requestBody=testDataReaderObj.getData(sourcePayload);
        }

        @When("user make a post call")
        public void user_make_a_post_call() {
            setEnvObj.setEnvironment();
            apiUtilsObj.postRequest(requestBody);
            prettyResponse=APIUtils.response.asPrettyString();
            System.out.println("prettyResponse :: "+prettyResponse);
        }

        @Then("user should receive the {int}")
        public void user_should_receive_the(Integer statusCode) {
            validationObj.validateStatusCode(statusCode);
        }

        @And("user should receive the {string} in the response body")
        public void user_should_receive_the_in_the_response_body(String attributeId) {
            System.out.println(attributeId);
            createMessagesObj.getIDValueFromResponse(attributeId,APIUtils.response);
        }


    @When("user make a get request to get the message details by using {string}")
    public void userMakeAGetRequestToGetTheMessageDetailsByUsing(String id) {
            setEnvObj.setEnvironment();
            apiUtilsObj.setPathParam(createMessages.id);
            apiUtilsObj.getResponse();
        prettyResponse=APIUtils.response.asPrettyString();
    }

    @Then("user should receive the <{int}>")
    public void userShouldReceiveThe(int statusCode) {
            validationObj.validateStatusCode(statusCode);
    }

}
