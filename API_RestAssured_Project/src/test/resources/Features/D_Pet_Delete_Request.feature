Feature: Verify DELETE request for Pet in petstore

Background:
	 Given pet api is active
	  
  Scenario: Verify Delete request for pet
    When User perform Delete operation 
    Then User recieves no records
    And Status code as 200