package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class loginAPI {
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
									+ "     \"userPassword\": \"Ab@2020\"\r\n"
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
	
	@Test(priority = 2)
	public void addProduct()
	{
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot (796).png";
		
		File image = new File(path); // object of upload image
		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		.relaxedHTTPSValidation()
		
		.header("Authorization", tokenValue)
		
		//sending form data by using .param()
		
		.param("productName", "casual shirt")
		
		.param("productAddedBy", userId)
		
		.param("productCategory", "fashion")
		
		.param("productSubCategory", "shirt")
		
		.param("productPrice", "1500")
		
		.param("productDescription", "Party wear shirt")
		
		.param("productFor", "Women")
		
		.multiPart("productImage", image )
		
		.when()
		
		.post("api/ecom/product/add-product")
		
		.then()
		
		.log()
		
		.all();
		
	}
	}
	
	
	
	
	
	
	


