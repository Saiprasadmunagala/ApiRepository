package ValidationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BodyValidation {
	
	@Test
	public void bodyValidationTest() {
		baseURI="http://localhost";
		port=8084;
		Response res = given()
		.get("/projects");
		
		String body=res.getBody().asString();
		boolean flag=false;
		if(body.contains("TY_PROJ_1602")) {
			flag=true;
			System.out.println("found");
		}
		Assert.assertTrue(flag);
		
	}
}
