package apicalls;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetAWorkspaceDetails {
	@Test
	public void GetAworkspacedetails()
	{
		RestAssured.baseURI="https://api.getpostman.com/";
		Response response = given()
							.relaxedHTTPSValidation()
							.header("x-api-key", "PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
							.when()
							.get("workspaces/b6699949-91c9-4e96-891a-1065114d36ac")
							.then()
							.extract()
							.response();
		String resp = response.asPrettyString();
		System.out.println(resp);
		
		
	}

}
