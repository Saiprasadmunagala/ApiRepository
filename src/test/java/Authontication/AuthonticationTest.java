package Authontication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthonticationTest {
	
	@Test
	public void preemtiveAuth() {
		
	given()
	.auth().preemptive().basic("rmgyantra", "rmgy@9999")
	.when()
	.get("http://localhost:8084/login")
	.then().log().all();
		
	}
}
