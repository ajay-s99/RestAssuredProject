package apicalls;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

//given is method inside RestAssured class and want to import as static

public class Get_method {
	
	@Test	
	public void getUserDetails() 
	{
		RestAssured.baseURI ="https://reqres.in";
		//baseURI is a method inside ResrAssured class
		//Response is interface		
		//given is method inside RestAssured class 
										
		Response apiresponse = given()				
							.relaxedHTTPSValidation()
	
							.when()	
							
							.get("/api/users?page=2")
							
							.then()
							
							.extract()
							
							.response();
		
		String stringResponse = apiresponse.asPrettyString();
		System.out.println(stringResponse);
		
		int apistatuscode = apiresponse.getStatusCode();
		System.out.println(apistatuscode);
		
		Assert.assertEquals(apistatuscode, 200);
		
		long timevalue = apiresponse.getTime(); //long is return value of local variable timevalue
		System.out.println(timevalue);
		
//		JsonPath js = apiresponse.jsonPath();
//		int path = js.getInt("page");
//		System.out.println(path);
		
	}

}
