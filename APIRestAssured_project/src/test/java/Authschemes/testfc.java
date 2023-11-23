package Authschemes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class testfc {
	@Test
	public void  q2apitest() 
	{ 
		RestAssured.baseURI= "https://api.firstconnect-staging.myhippo.io";
		
								given()
								.relaxedHTTPSValidation()
								.header("authority","api.firstconnect-staging.myhippo.io")
								.header("accept","application/json, text/plain, */*")
								.header("accept-language","en-US,en;q=0.7")
								.header("authorization","Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImplOUdadkdrMmktbjQ2WlBqVEtxNyJ9.eyJwcm9kdWNlcl9pZCI6MTE4MDgsImlzcyI6Imh0dHBzOi8vYXV0aC5maXJzdGNvbm5lY3Qtc3RhZ2luZy5teWhpcHBvLmlvLyIsInN1YiI6ImF1dGgwfDExODA4IiwiYXVkIjpbImh0dHBzOi8vYXBpLmZpcnN0Y29ubmVjdC1zdGFnaW5nLm15aGlwcG8uaW8vIiwiaHR0cHM6Ly9maXJzdGNvbm5lY3Qtc3RhZ2luZy51cy5hdXRoMC5jb20vdXNlcmluZm8iXSwiaWF0IjoxNjkxNDcyNjg2LCJleHAiOjE2OTE0Nzk4ODYsImF6cCI6IkFIaGZVcGhPcE5rQmdndmJqQnVqaklMelN3VzVTMG9TIiwic2NvcGUiOiJvcGVuaWQgZW1haWwifQ.ho88hktC9W6BAhygIxyxx12g9Df_CN70jcOwlI0W2mTMfEAQ1HkxDcuxbbIF3i-efhI8AowpkTHiLG8NZ7a6i-opv5Cgim1KiqZKQFrUJl1RtWW0K_HLnnXVDlCozdU0afpMVWigITr3K1DuYwPbmSXc1xcU76PmIiTZ4bPPSDYEM3WRLEM0N_-fbCLEQQqj34sQhrFsV83PeGkZzzuslPEwf59dBef7V16i69RimuQTMMp3MeuCev5_YNyu3HIGdSptlpfl0FscKkHHhoGP1_I2mcZGXIMZ4-BD8VclBi-HFe80m_YqLVDM0cXsPgAQRqxdb1cVWtBQq8zx8BFrUg")
								.header("if-none-match","W/\"824-kaWwUDvaio20vfGVmROsFoV9xK0\"")
								.header("origin","https://portal.firstconnect-staging.myhippo.io")
								.header("referer","https://portal.firstconnect-staging.myhippo.io/")
								.header("sec-ch-ua","Not/A)Brand\";v=\"99\", \"Brave\";v=\"115\", \"Chromium\";v=\"115\"")
								.header("sec-ch-ua-mobile","?0")
								.header("sec-ch-ua-platform","\"Windows\"")
								.header("sec-fetch-dest","empty")
								.header("sec-fetch-mode","cors")
								.header("sec-fetch-site","same-site")
								.header("sec-gpc","1")
								.header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
								
								.log().all()
	
								.when()
								
								.get("/api/v1/producer/q2-incetive-policies/11808")
								
								.then()
								
								.log().all();
	

}
}
