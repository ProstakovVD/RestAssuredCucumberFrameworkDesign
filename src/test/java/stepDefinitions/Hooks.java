package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	APIStepDefinitions sd = new APIStepDefinitions();
	
	@Before("@DeletePlace")
	public void beforeScenarion() throws Throwable {
		
		if(APIStepDefinitions.id==null) {
			
			sd.add_place_payload_with_("test1", "test2", "test3");
			sd.user_is_calling_with_http_request("AddPlaceAPI", "POST");
			sd.verify_placeid_created_maps_to_using("test1", "GetPlaceAPI");
			
		}
		
	}
	
}
