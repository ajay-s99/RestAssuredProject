package apicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateWorkspace {
	//Post method
	
	@Test
	public void creatworkspace()
	{
		RestAssured.baseURI="https://api.getpostman.com/";
		
		Response response = given()
				.relaxedHTTPSValidation()
				.body("{\r\n"
						+ "    \"workspace\": {\r\n"
						+ "        \"name\": \"Manualworkspace\",\r\n"
						+ "        \"type\": \"personal\",\r\n"
						+ "        \"description\": \"This workspace is created just for testing\"\r\n"
						+ "    }\r\n"
						+ "}")
				//this is post method, we have to send json data inside body.
				.header("x-api-key","PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
				.when()
				.post("workspaces")
				.then()
				.extract()
				.response();
		
		String stringresponse=	response.asPrettyString();
		
		System.out.println(stringresponse);
	}
}
