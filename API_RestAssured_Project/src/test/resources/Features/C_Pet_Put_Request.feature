Feature: Verify PUT request for Pet in petstore

Background:
	Given pet api is active
	 
  Scenario: Verify Put request for pet
    When User perform Put operation with valid payload
    Then User recieves valid response for put
    And Valid status code for put
    
  Scenario: Verify Put request for pet 
    When User perform Put operation with invalid payload
    Then User recieves valid response for put
    And Valid status code1 for put