Feature: Validate Place API's

	@AddPlace
  Scenario Outline: Verify if AddPlaceAPI works as expected
    Given Add Place Payload with <name>,<website>,<phone>
    When user is calling "AddPlaceAPI" with "POST" http request
    Then the API call is a success with status code "200"
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to <name> using "GetPlaceAPI"
    
    Examples:
    | name 			| website 						| phone 						 |
    |UsualName|http://google.com|(+91) 983 893 3937|
 #   |UsualNam|http://google.com|(+91) 983 893 3939|
    
  @DeletePlace  
  Scenario: Verify if DeletePlaceAPI is working
  	Given Delete Place Payload
  	When user is calling "DeletePlaceAPI" with "DELETE" http request
  	Then the API call is a success with status code "200"
  	And "status" in response body is "OK"