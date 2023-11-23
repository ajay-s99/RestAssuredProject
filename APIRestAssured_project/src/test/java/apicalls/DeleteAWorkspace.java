package apicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteAWorkspace {
	@Test
	public void deleteaworkspace()
	{
		RestAssured.baseURI="https://api.getpostman.com/";
		//baseURI is a method inside ResrAssured class
		Response response = given()
		//Response is interface	//given is method inside RestAssured class 
				.relaxedHTTPSValidation()
				
				.header("x-api-key","PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
				.when()
				.delete("workspaces/abd46204-d0d7-406a-aada-7b4c22169ea8")
				.then()
				.extract()
				.response();
		String resp = response.asPrettyString();
		System.out.println(resp);
		
	}

}
