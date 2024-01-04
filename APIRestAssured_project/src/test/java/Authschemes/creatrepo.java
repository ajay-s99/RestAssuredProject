package Authschemes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class creatrepo {
	@Test
	public void creatRepo()
	{
		// Example- https://docs.github.com/rest/repos/repos#list-repositories-for-the-authenticated-user
		RestAssured.baseURI= "https://api.github.com";
								given()
								.relaxedHTTPSValidation()	
								.header("Accept", " application/vnd.github+json")
								
								.header("Authorization", "Bearer TOKEN")
								
								.header("X-GitHub-Api-Version", " 2022-11-28")
								
								.body("{\r\n"
										+ "  \"name\": \"NameOfRepo\",\r\n"
										+ "  \"description\": \"Discription\",\r\n"
										+ "  \"homepage\": \"https://github.com\",\r\n"
										+ "  \"private\": false,\r\n"
										+ "  \"is_template\": true\r\n"
										+ "}")
								
								.log().all()
								
								.when()
								
								.post("/user/repos")
								
								.then()
								
								.log().all();
	}

}
