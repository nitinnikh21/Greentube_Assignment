package stepDefs;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pet_Delete_Steps {
	Response resp;
	
//	@Given("pet api is active")							// Part of Background
//	public void pet_api_is_active() {
//		System.out.println("Given statement initiated");
//		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
//	}
	
	@When("User perform Delete operation")
	public void user_perform_delete_operation() {
		System.out.println("When statement initiated");
		   resp = RestAssured.given().delete("/10001");
		  
	}

	@Then("User recieves no records")
	public void user_recieves_no_records() {
		System.out.println("Then statement initiated");
	    resp.prettyPeek();
	    System.out.println(resp.getBody().asString());
			   
	}

	@Then("Status code as {int}")
	public void status_code_as(Integer int1) {
		resp.then().statusCode(200);
		 Assert.assertEquals(200, resp.getStatusCode());
	}

}
