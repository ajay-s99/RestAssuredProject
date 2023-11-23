package FetchDatafromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchFNfromallindex {
	@Test
	public void fetchfirstnamefromindex() 
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
			//with the help of jsonPath() we can retrieve data from response
			
			int numberofelements = js.getInt("data.size()"); //to know the size/length of array 
			System.out.println("Total number of elements present: "+numberofelements);
			
// NOTE = to get the total no of element we use .size method
			
			//Fetching First name of user from all index
			for (int i=0; i<=5; i++)
			{
				String firstname = js.getString("data["+i+"].first_name");
				System.out.println(firstname);
			}
	}

}
