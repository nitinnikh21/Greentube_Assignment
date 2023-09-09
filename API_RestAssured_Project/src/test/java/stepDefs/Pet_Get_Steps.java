package stepDefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Pet_Get_Steps {
	Response resp;
	
	@Given("pet api is active")
	public void pet_api_is_active() {
		System.out.println("Given statement initiated");
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
	    
	}

	@When("User perform GET operation with valid ID")
	public void user_perform_get_operation_with_valid_id() {
		System.out.println("When statement initiated");
	   resp = RestAssured.given().get("/10001");
	   resp.prettyPeek();
	}

	@Then("User recieves valid response")
	public void user_recieves_valid_response() {
		System.out.println("Then statement initiated");
	    resp.prettyPeek();
	    System.out.println(resp.getBody().asString());
//		resp.then().statusCode(404);
		 Assert.assertEquals(200, resp.getStatusCode());
		 Assert.assertEquals(10001, resp.getBody().path("id"));			// Verification of ID generated by POST request In GET
		 
	    
	}
	
	@When("User perform GET operation with invalid ID")
	public void user_perform_get_operation_with_invalid_id() {
	   resp = RestAssured.get("/1wse");
	}

	@Then("User recieves {int} response code")
	public void user_recieves_response_code(Integer int1) {
	    resp.then().statusCode(404);
	    Assert.assertEquals(404, resp.getStatusCode());
	}
	
	@When("User perform GET operation with invalid URL")
	public void user_perform_get_operation_with_invalid_url() {
		resp = RestAssured.get("//////////////");
	}
	
	@Then("User recieves {int} response code1")
	public void user_recieves_response_code1(Integer int1) {
	    resp.then().statusCode(404);
	    Assert.assertEquals(404, resp.getStatusCode());
	}


}