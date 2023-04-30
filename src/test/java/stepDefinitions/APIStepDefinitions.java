package stepDefinitions;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.EnumAPI;
import utils.Reusable;
import utils.TestDataBuild;

public class APIStepDefinitions extends Reusable{

	RequestSpecification req;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String id;
	
	@Given("^Add Place Payload with (.+),(.+),(.+)$")
    public void add_place_payload_with_(String name, String website, String phone) throws Throwable {

		req = RestAssured
			.given()
				.spec(requestSpecification())
				.body(data.addPlacePayload(name,website,phone));
		
    }
	
    @Given("^Delete Place Payload$")
    public void delete_place_payload() throws Throwable {
    		
    	req = RestAssured
    		.given()
    			.spec(requestSpecification())
    			.body(data.deletePlacePayload(id));
    	
    }

    @When("^user is calling \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_is_calling_with_http_request(String resource,String method) throws Throwable {
    	
    	if(method.equalsIgnoreCase("POST")) {
    
    		response = req
    			.when()
					.post(EnumAPI.valueOf(resource).getResource());
    	
    	} else if(method.equalsIgnoreCase("GET")) {
    		
    		response = req
    			.when()
					.get(EnumAPI.valueOf(resource).getResource());
    		
    	} else if(method.equalsIgnoreCase("DELETE")) {
    		
    		response = req
        		.when()
    				.delete(EnumAPI.valueOf(resource).getResource());
    		
    	}
		
    }

    @Then("^the API call is a success with status code \"([^\"]*)\"$")
    public void the_api_call_is_a_success_with_status_code(Integer expectedCode) throws Throwable {

    	Assertions.assertThat(response.getStatusCode()).isEqualTo(expectedCode);
    	
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void in_response_body_is(String keyValue, String expectedValue) throws Throwable {

    	Assertions.assertThat(Reusable.getJsonPath(response,keyValue)).isEqualTo(expectedValue);
    	
    }
    

    @And("^verify place_Id created maps to (.+) using \"([^\"]*)\"$")
    public void verify_placeid_created_maps_to_using(String expectedValue, String resource) throws Throwable {

    	req = RestAssured
    			.given()
    				.spec(requestSpecification())
    				.queryParam("place_id", Reusable.getJsonPath(response,"place_id"));
    	id = Reusable.getJsonPath(response,"place_id");
    	user_is_calling_with_http_request(resource,"GET");
    	Assertions.assertThat(Reusable.getJsonPath(response,"name")).isEqualTo(expectedValue);
    	
    }
	
}
