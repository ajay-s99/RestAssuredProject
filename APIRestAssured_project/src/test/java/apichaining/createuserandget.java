package apichaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class createuserandget {
//Part-7 30:00	
	
	@Test(priority = 1 )
	public void creatanuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
							given()
							
							.relaxedHTTPSValidation()
							.body("{\r\n"
									+ "  \"id\": 0,\r\n"
									+ "  \"username\": \"Johnsmith\",\r\n"
									+ "  \"firstName\": \"smith\",\r\n"
									+ "  \"lastName\": \"john\",\r\n"
									+ "  \"email\": \"smith@yopmail.com\",\r\n"
									+ "  \"password\": \"string@12345\",\r\n"
									+ "  \"phone\": \"8889966523\",\r\n"
									+ "  \"userStatus\": 0\r\n"
									+ "}")
							.header("Content-Type","application/json")
							//this is post method so we are using header method 
							.log().all()
							.when()
							.post("/user")
							.then()
							.log().all();							
	}
	@Test(priority = 2)
	public void getUserdetails()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		given()
		.relaxedHTTPSValidation()
		.pathParam("createdusername", "Johnsmith")
		.when()
		.get("/user/{createdusername}")
		.then()
		.log().all();
		
		
		
	}

}
