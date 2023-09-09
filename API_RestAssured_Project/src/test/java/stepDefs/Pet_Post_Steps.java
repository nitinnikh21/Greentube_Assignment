package stepDefs;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Pet_Post_Steps {
	Response resp;
	File payload = new File("src/test/resources/Payload/Pet_Post_Payload.json");
	File invalid_payload = new File("src/test/resources/Payload/Pet_Post_Payload_Invalid.json");
	public int post_pet_Id ; 
//	
////	@Given("pet api is active")
////	public void pet_api_is_active() {
////		System.out.println("Given statement initiated");
////	    RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
////	}
//	
	@When("User perform POST operation with valid payload")
	public void user_perform_post_operation_with_valid_payload() {
		System.out.println("When statement initiated");
	    resp = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).
	    						body(payload).
	    					when().post();
	}
//	
	@Then("User recieves valid response for post")
	public void user_recieves_valid_response_for_post() {
		System.out.println("Then statement initiated");
	    resp.prettyPeek();
	    System.out.println(resp.getBody().asString());
	}
	@And("Valid status code")
	public void valid_status_code() {
		System.out.println("And statement initiated");
//		resp.then().statusCode(200);
//	    resp.then().statusLine("HTTP/1.1 200 OK");
	    Assert.assertEquals(200, resp.getStatusCode());
	    Assert.assertEquals("HTTP/1.1 200 OK", resp.getStatusLine());
	    Assert.assertEquals(10001, resp.getBody().path("id"));
	    Assert.assertEquals("Labrador", resp.getBody().path("category.name"));
	    
	}
	
//	
	@When("User perform POST operation without payload")
	public void user_perform_post_operation_without_payload() {
	   resp = RestAssured.given().accept(ContentType.JSON).body("").when().post();
	}
//
	@Then("User recieves {int} status code")
	public void user_recieves_status_code(Integer int1) {
	   resp.then().statusCode(415);
	   Assert.assertEquals(415, resp.getStatusCode());
	}
	
//	
	@When("User perform POST operation with Invalid Id in payload")
	public void user_perform_post_operation_with_invalid_id_in_payload() {
		resp = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON).
				body(invalid_payload).
			when().post();
	}
//	
	@Then("User recieves {int} status code2")
	public void user_recieves_status_code2(Integer int1) {
	   resp.then().statusCode(500);
	   Assert.assertEquals(500, resp.getStatusCode());
	   
	}
}
