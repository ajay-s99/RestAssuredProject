package Serializationanddeserialiaztion;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.CreatUserResponseBody;
import pojo.CreateUserRequestBody;

public class CreateUser {

	@Test(priority = 1 )
	public void creatanuser()
	
	{
		CreateUserRequestBody crub= new CreateUserRequestBody();
		//Object created of pojo class to call non static method from pojo class.
		
		crub.setId(0);
		crub.setUsername("Serialization");
		crub.setFirstName("steve");
		crub.setLastName("Smith");
		crub.setEmail("john1smith@yopmail.com");
		crub.setPassword("Test@123");
		crub.setPhone("9822556644");
		crub.setUserStatus(0);
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		 CreatUserResponseBody CreatUserResponse = given()
							
							.relaxedHTTPSValidation()
							.body(crub)  //when we are sending body that time serialization will perform
							
							.header("Content-Type","application/json")
							//this is post method so we are using header method 
							.log().all()
							.when()
							.post("/user")
							.then()
							.log().all()
							.extract()
							.response()
							 
							//De-serialization starts
							.as(CreatUserResponseBody.class);
		 
		 String messagevalue = CreatUserResponse.getMessage();
		 System.out.println(messagevalue);
		 
		 String usertype = CreatUserResponse.getType();
		 System.out.println(usertype);
		 
		 String usercode = CreatUserResponse.getCode();
		 System.out.println(usercode);
	}
}
