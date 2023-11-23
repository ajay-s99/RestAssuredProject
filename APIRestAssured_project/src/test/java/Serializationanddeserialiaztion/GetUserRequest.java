package Serializationanddeserialiaztion;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Data;
import pojo.GetUserResponseBody;

public class GetUserRequest {

	@Test
	public void getUserDetails() 
	{
		RestAssured.baseURI ="https://reqres.in";
		//baseURI is a method inside ResrAssured class
		//Response is interface		
		//given is method inside RestAssured class 
										
		 GetUserResponseBody getUserSupportBody = given()				
							.relaxedHTTPSValidation()
	
							.when()	
							
							.get("/api/users?page=2")
							
							.then()
							.log().all()
							
							.extract()
							
							.response()
							
							//Getting response in json format so performing de-serialization
							
							.as(GetUserResponseBody.class);
		 
		Integer totalpages = getUserSupportBody.getTotal_pages();
		
		System.out.println(totalpages);
		
//		Fetching firstname from zeroth index position from Array in the json
		
		List<Data> listArray = getUserSupportBody.getData(); //object from GetUserResponseBody class
		//listArray is a variable
		
		Data zerothIndex = listArray.get(0);
		
		String zerothFirstname = zerothIndex.getFirst_name();
		
		System.out.println(zerothFirstname);
		
		
//		Fetching all firstname from the Array:
		
		for(int i = 0; i<listArray.size(); i++)
		{
		String firstname = getUserSupportBody.getData().get(i).getFirst_name();
		System.out.println(firstname);
		}
		
// 		Fetching All email		

		for(int i=0; i<listArray.size();i++)
		{	
		String fue = getUserSupportBody.getData().get(i).getEmail();
		System.out.println("Email = "+fue);
		}
		
//		Fetching last name of all users
		
		for(int i=0; i<listArray.size(); i++)
		{
			String LNU = getUserSupportBody.getData().get(i).getLast_name();
			System.out.println(LNU);
		}
		
//		Fetching id of all users		
		
		for(int i=0; i<listArray.size();i++)
		{
			Integer idofuser = getUserSupportBody.getData().get(i).getId();
			System.out.println(idofuser);
		}
}
	
}