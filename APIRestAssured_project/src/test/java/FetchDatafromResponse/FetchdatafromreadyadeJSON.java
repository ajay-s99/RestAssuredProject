package FetchDatafromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchdatafromreadyadeJSON {
	
	
	@Test
	public void fetchdata()
	{
		
		String jsonbody="{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		// creating object of json path class		
		JsonPath jsonpath = new JsonPath(jsonbody);
		
		String website = jsonpath.getString("dashboard.website");
		System.out.println(website);
		
// 1. Print No of courses returned by API
		
		int noofcourses = jsonpath.getInt("courses.size()");
		System.out.println("No of courses available: "+ noofcourses);
		
//2. Print the purchase amount
		
		int purchaseamt = jsonpath.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase amount is: "+ purchaseamt);
		
//3. Print the title of first course
//4. Print all course title and their respective price
//5. Print no of copies sold by RPA course 
//6. Verify if sum of all course price matches with purchase amt		
		
	}

}
