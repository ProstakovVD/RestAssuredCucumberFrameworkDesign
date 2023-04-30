package legacy;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class First {

	RequestSpecification req;
	ResponseSpecification res;
	RequestSpecification addPlaceReq;
	Response addPlaceResponse;
	
	@Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {

		List<String> myList = new ArrayList<String>();
			myList.add("shoe park");
			myList.add("shop");
		Location l = new Location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
		AddPlace ap = new AddPlace();
			ap.setTypes(myList);
			ap.setLocation(l);
			ap.setAccuracy(50);
			ap.setAddress("29, side layout, cohen 09");
			ap.setLanguage("French-IN");
			ap.setPhone_number("(+91) 983 893 3937");
			ap.setWebsite("ajcn");
			ap.setName("UsualName");
		
		req = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.build();
		res = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectHeader("server", "Apache/2.4.41 (Ubuntu)")
				.build();
		
		addPlaceReq = RestAssured
			.given()
				.spec(req)
				.body(ap);
		
    }

    @When("^user is calling \"([^\"]*)\" with POST http request$")
    public void user_is_calling_with_post_http_request(String strArg1) throws Throwable {

		addPlaceResponse = addPlaceReq
			.when()
				.post("/maps/api/place/add/json")
			.then()
				.spec(res)
				.extract()
					.response();
    	
    }

    @Then("^the API call is a success with status code \"([^\"]*)\"$")
    public void the_api_call_is_a_success_with_status_code(Integer intArg1) throws Throwable {

    	Assertions.assertThat(addPlaceResponse.getStatusCode()).isEqualTo(200);
    	
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void in_response_body_is(String strArg1, String strArg2) throws Throwable {

    	JsonPath jp = new JsonPath(addPlaceResponse.asString());
    	Assertions.assertThat(jp.getString(strArg1).toString()).isEqualTo(strArg2);
    	
    }
	
}
