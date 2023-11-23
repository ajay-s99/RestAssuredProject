package FetchDatafromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.response.Response.*;

public class FetchLNwhoseemailis {
	
	@Test
	public void fetchlastnamewhoesemailis()
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
			
			//Fetching last name of user whose email is george.edwards@reqres.in
			for (int i=0; i<=5; i++)
			{
				String email = js.getString("data["+i+"].email");
				
				if(email.equals("george.edwards@reqres.in"))
				{
					String lastname = js.getString("data["+i+"].last_name");
					System.out.println(lastname);
				}
			
				
			}
			
			
			
//			String idno = js.getString("data[0].id");
//			
//			if(idno.equals("7"))
//			{
//				String lastname = js.getString("data[0].last_name");
//				System.out.println(lastname);
//			}
	}

}
