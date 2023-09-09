Feature: Verify GET request for Pet in petstore

Background:
	 Given pet api is active
 
  Scenario: Verify GET request for pet
    When User perform GET operation with valid ID
    Then User recieves valid response

 Scenario: Verify GET request for pet
    When User perform GET operation with invalid ID
    Then User recieves 404 response code
    
 Scenario: Verify GET request for pet
    When User perform GET operation with invalid URL
    Then User recieves 404 response code1