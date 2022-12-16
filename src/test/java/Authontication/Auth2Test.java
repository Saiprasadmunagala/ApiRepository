package Authontication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2Test {
	
	@Test
	public void authentication() {
		
		Response response=given()
		.formParam("client_id", "sdet38")
		.formParam("client_secret", "6796fa458caa5e5226ad1850936cf3f1")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://saiprasad.com")
		.formParam("code", "3888")//3888
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println("response is : "+response);
		String token = response.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3888)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs_count")
		.then().log().all();
		
	
		
	}
	
}
