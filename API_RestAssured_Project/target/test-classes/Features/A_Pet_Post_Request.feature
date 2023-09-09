Feature: Verify POST request for Pet in petstore

Background: 
	Given pet api is active
 
  Scenario: Verify Post request for pet
    When User perform POST operation with valid payload
    Then User recieves valid response for post
    And Valid status code
   
  Scenario: Verify Post request for pet
    When User perform POST operation without payload
    Then User recieves 415 status code
    
  Scenario: Verify Post request for pet
    When User perform POST operation with Invalid Id in payload
    Then User recieves 500 status code2
    