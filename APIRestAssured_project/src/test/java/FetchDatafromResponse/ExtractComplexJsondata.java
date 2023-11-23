package FetchDatafromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ExtractComplexJsondata {

	@Test
	public void extractcomplexjsondata() 
	{
		RestAssured.baseURI ="https://reqres.in";
		Response apiresponse = given()	
				
				.relaxedHTTPSValidation()

				.when()	
				
				.get("/api/users?page=2")
				
				.then()
				
				.extract()
				
				.response();

			String stringResponse = apiresponse.asPrettyString();
			System.out.println(stringResponse);
			
			JsonPath js = apiresponse.jsonPath();
			//with the help of jsonPath() we can retrive data from response
			String pathvalue = js.getString("data[0].email");
			System.out.println(pathvalue);
	}
}
