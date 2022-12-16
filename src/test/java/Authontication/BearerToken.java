package Authontication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void authontication() {
		
		given()
		.auth().oauth2("ghp_As19hDFcNqrBBzrcOyJUyuxzIph5H237vccl")
		.when()
		.get("http://api.github.com/user/repos")
		.then()
		.assertThat().log().all();
		
	} 
	
}
