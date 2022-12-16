package ValidationTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetSingleProjectBodyValidation {

	@Test
	public void GetSingleProjectBodyValidationTest()
	{
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