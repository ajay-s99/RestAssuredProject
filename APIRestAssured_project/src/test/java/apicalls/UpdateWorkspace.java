package apicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdateWorkspace {
	@Test
	public void updateworkspace()
	{
RestAssured.baseURI = "https://api.getpostman.com";
		
		Response response = given()
							.relaxedHTTPSValidation()
		
							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"Manualworkspace\",\r\n"
									+ "        \"type\": \"team\",\r\n"
									+ "        \"description\": \"This workspace is created to delete \"\r\n"
									+ "    }\r\n"
									+ "}")
							
							.header("x-api-key", "PMAK-64ba1da68e4e54004ffc6124-e5efa589be6162edfbc47a0f26c5f83431")
							
							.when()
							
							.put("/workspaces/ada4a742-7afa-42fc-bcc8-2620752414db")
							
							.then()
							
							.extract()
							
							.response();
		
		
	String stringresponse=	response.asPrettyString();
	
	System.out.println(stringresponse);
				
				
	}

}
