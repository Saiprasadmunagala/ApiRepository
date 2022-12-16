package ValidationTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class GetProjectWithoutEndPoint {
	@Test
	public void getProjectWithoutEndPointTest()
	{baseURI="http://localhost";
	port=8084;
	String expectedContent="application/json";
	String expectVary="Access-Control-Request-Headers";
	Response res = given()
	.get("/project");
	String actualContent = res.getContentType();
	String actualVary = res.getHeader("vary");
	res.then().log().all();
	Assert.assertEquals(expectedContent, actualContent);
	Assert.assertEquals(actualVary, expectVary);
		
	}
	
}