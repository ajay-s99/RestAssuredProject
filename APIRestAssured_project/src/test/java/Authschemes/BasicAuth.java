package Authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class BasicAuth {
	
	@Test
	public void executeGetEcho()
	{
		RestAssured.baseURI = "https://postman-echo.com";
		
								given()
								.relaxedHTTPSValidation()
										
								.auth()
								
								.basic("postman", "password") //less secure
								
								.log().all()
								
								.when()
								
								.get("/basic-auth")
								
								.then()
								
								.log().all();
	
	}

}
