package apicalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Headmethodcall {
	@Test
	public void GetallworkspacewithHead()
	{
RestAssured.baseURI="https://api.getpostman.com/";
		
				 Response resp = given()
								.relaxedHTTPSValidation()
								.header("x-api-key", "PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
								.when()
								.head("/workspaces")
								.then()
								.extract()
								.response();
				 int statuscode = resp.statusCode();
				 System.out.println(statuscode);
								
								
		//Using Head method so we are not getting any response
		
		
	}

}
