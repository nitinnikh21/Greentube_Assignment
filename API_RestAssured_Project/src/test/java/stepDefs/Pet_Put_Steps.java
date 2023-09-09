package stepDefs;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Pet_Put_Steps {
	Response resp;
	File putPayload = new File ("src/test/resources/Payload/Pet_Put_Payload.json");
	File Invalid_putPayload = new File ("src/test/resources/Payload/Pet_Put_Payload.json");
	
//@Given("pet api is active")					// Part of Background
//public void pet_api_is_active() {
//	System.out.println("Given statement initiated");
//    RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
//}
	
	@When("User perform Put operation with valid payload")
	public void user_perform_put_operation_with_valid_payload() {
		System.out.println("When statement initiated");
	    resp = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).
	    						body(Invalid_putPayload).
	    					when().post();
	}

	@Then("User recieves valid response for put")
	public void user_recieves_valid_response_for_put() {
		System.out.println("Then statement initiated");
	    resp.prettyPeek();
	    System.out.println(resp.getBody().asString());
	    
	}

	@Then("Valid status code for put")
	public void valid_status_code_for_put() {
		System.out.println("Then statement initiated");
		resp.then().statusCode(200);
	    resp.then().statusLine("HTTP/1.1 200 OK");
	    Assert.assertEquals(200, resp.getStatusCode());
	    Assert.assertEquals("HTTP/1.1 200 OK", resp.getStatusLine());
	    Assert.assertEquals("Sold", resp.getBody().path("status"));			//Upddated attribute
	    
	}
	
	@When("User perform Put operation with invalid payload")
	public void user_perform_put_operation_with_invalid_payload() {
		System.out.println("When statement initiated");
	    resp = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).
	    						body(putPayload).
	    					when().post();
	}
	@Then("Valid status code1 for put")
	public void valid_status_code1_for_put() {
		System.out.println("Then statement initiated");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(400, resp.getStatusCode());
	    
	}

}
