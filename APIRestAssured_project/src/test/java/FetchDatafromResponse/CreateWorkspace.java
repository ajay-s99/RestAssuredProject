package FetchDatafromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateWorkspace {
	
	@Test
	public void createworkspace() 
	{
RestAssured.baseURI="https://api.getpostman.com/";
		
		Response apiresponse = given()
							.relaxedHTTPSValidation()
							.body("{\r\n"
									+ "    \"workspace\": {\r\n"
									+ "        \"name\": \"workspaceTo get data\",\r\n"
									+ "        \"type\": \"personal\",\r\n"
									+ "        \"description\": \"workspace to get data from jason\"\r\n"
									+ "    }\r\n"
									+ "}")
							//this is post method, we have to send json data inside body.
							.header("x-api-key","EnterKey")
							.when()
							.post("workspaces")
							.then()
							.extract()
							.response();
		
		String stringresponse=	apiresponse.asPrettyString();		
		System.out.println(stringresponse);
		
		//To fetch data from response using json path method
		
		JsonPath js = apiresponse.jsonPath();		
		//js is object of JsonPath class.
		
		String idvalue = js.getString("workspace.id");
		// we can use idvalue it is variable.
		
		System.out.println("New created workspace id:" +idvalue);
	}
	

}
