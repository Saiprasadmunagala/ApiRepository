package ValidationTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HeaderValidation {
	
	@Test
	public void headerValidation() {
		
		baseURI="http://localhost";
		port=8084;
		String expectedContent="application/json";
		String expectedStatuaLine="HTTP/1.1 500 ";
		Response res = given()
		.post("/projects");
		String actualContent = res.getContentType();
		String statusLine = res.getStatusLine();
		res.then().log().all();
		Assert.assertEquals(expectedContent, actualContent);
		Assert.assertEquals(statusLine, expectedStatuaLine);
			
	}
}
