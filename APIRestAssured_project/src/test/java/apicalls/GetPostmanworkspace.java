package apicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetPostmanworkspace {
	@Test
	public void getallworkspace()
	{
		RestAssured.baseURI="https://api.getpostman.com/";
		
		Response apiresponse = given()
								.relaxedHTTPSValidation()
								.header("x-api-key", "PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
								.when()
								.get("/workspaces")
								.then()
								.extract()
								.response();
								
		String resp = apiresponse.asPrettyString();
		System.out.println(resp);
		
	}

}
