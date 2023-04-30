package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class First {

	@Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {

		AddPalce ap = new AddPalce();
		
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.build();
		ResponseSpecification res = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectHeader("server", "Apache/2.4.41 (Ubuntu)")
				.build();
		
    }

    @When("^user is calling \"([^\"]*)\" with POST http request$")
    public void user_is_calling_something_with_post_http_request(String strArg1) throws Throwable {

    	
    	
    }

    @Then("^the API call is a success with status code 200$")
    public void the_api_call_is_a_success_with_status_code_200() throws Throwable {

    	
    	
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {

    	
    	
    }
	
}
