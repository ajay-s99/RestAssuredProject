package Authschemes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Bearertoken {
	
	@Test
	public void getRepository()
	{
		// Example- https://docs.github.com/rest/repos/repos#list-repositories-for-the-authenticated-user
		RestAssured.baseURI= "https://api.github.com";
								given()
								.relaxedHTTPSValidation()	
								.header("Accept", "application/vnd.github+json")
								
								.header("Authorization", "Bearer TOKEN")
								
								.header("X-GitHub-Api-Version", "2022-11-28")
								.log().all()
								
								.when()
								
								.get("/user/repos")
								
								.then()
								
								.log().all();
	}

}
