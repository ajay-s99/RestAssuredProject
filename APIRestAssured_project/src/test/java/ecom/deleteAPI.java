package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class deleteAPI {
	
	static	String tokenValue;
	static String userId;
	
	@Test(priority = 1)
	public void logintoapp() 
	{
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		Response response = given()
							.relaxedHTTPSValidation()
							
							.header("Content-Type", "application/json")
							
							.body("{\r\n"
									+ "    \"userEmail\": \"aron@yopmail.com\",\r\n"
									+ "     \"userPassword\": \"Firstconnect@2020\"\r\n"
									+ "}")
							
							.log().all()
							
							.when()
							
							.post("/api/ecom/auth/login")
							
							.then()
							
							.log().all()
							
							.extract()
							
							.response();
		//sending json body thats why we are using jsonPath
		
		JsonPath jp = response.jsonPath();
		
		tokenValue = jp.getString("token");
		
		userId = jp.getString("userId");
		
	}
	
	@Test (priority = 2)
	public void deleteprodct()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
				
									given()
									.relaxedHTTPSValidation()
									
									.header("Authorization", tokenValue)
									
									.when()	
									
									.delete("api/ecom/product/delete-product/64c4ec257244490f958fb4b0")
									
									.then()
									
									
									.log()
									
									.all();
	}

}
