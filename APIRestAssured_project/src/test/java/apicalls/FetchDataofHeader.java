package apicalls;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FetchDataofHeader {
	@Test 
	public void fetchdataofheader()
	{
		RestAssured.baseURI ="https://reqres.in";
		Response apiresponse = given()	
				
								.relaxedHTTPSValidation()
								.log().all()
				
								.when()	
								
								.get("/api/users?page=2")
								
								.then()													
								
								.extract()
								
								.response();
/*NOTE= log().all()	method used to fetch header data in given and response
& if we used this method then there is no requirement of .asPrettyString()*/
				
				Headers header = apiresponse.headers();
				//.headers() method inside a headers class is present in rest Assured
				/*To print response header value we have call headers method
				 * for that we have to conver*/				
								
				String headervalue = header.toString();// this will return complete header values
				System.out.println(headervalue);
				
				//fetch specific value of header
				String server = apiresponse.getHeader("Server"); // This will return the specific value of header..
				System.out.println("Server name is: "+server);
				
	 


	}

}
