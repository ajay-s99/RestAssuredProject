package AssertionsinRestAssured;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 

public class Assertionusage {
	
	@Test
	public void assertionusage() 
	{
		RestAssured.baseURI="https://api.getpostman.com/";
		
								given()
				
								.relaxedHTTPSValidation()
								
								.header("x-api-key", "POSTMANKEY")
								
								.when()
								
								.get("/workspaces")
								
								.then()
								
								//Assertion always used during validation part ie. after .then()
								
								.assertThat()
								.statusCode(200)
								.contentType(ContentType.JSON)
								.header("Connection","keep-alive")
								
								
								.log().all()
								
								.body("workspaces[1]", hasKey("id"))// verifying whether array has an element 'id' 
								.body("workspaces.name", contains("My Workspace","Team Workspace","Manualworkspace2","workspaceTo get data","Deleteworkspace1"));
								// above line validates whether the name has all possible values in a specific sequence using .contains() method.
		
	}

}
