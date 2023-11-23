package Spotify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetUserProfileId {
	
	@Test
	public void getUserId() 
	{
		RestAssured.baseURI="https://api.spotify.com/v1";
								given()
								.relaxedHTTPSValidation()
								.header("Authorization","Bearer BQD-w5DvYcgMTBDwrY48SOk0IQMur2YvHMr9qAicVJzBH_F48b-mqWXRd1Y46X4fQpkv0LkIIqJqPpZgsVvjSzzbIA5vuPs6W2kaWP_xUWIWW3vUlOFmw9IGjOFhF4W15ENuwvNwagx7AReIeFt6FmTYhfwZCwFfFX2XLeolSxLG6lkF4mzCzGE-ZXvXbUX9MFRJku8Zp4nAoYJaj869aRKBgpno38_FMFBcmC-A6GDDR8d8fpq24klWCzlbny_y5c43E6RujtbYm04N")
								.when()
								.get("/me")
								.then()
								.log().all()
								.extract()
								.response();
	}
	

}
