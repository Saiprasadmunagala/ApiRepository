package ValidationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StatusLineValidationTest {
	@Test
	public void statuslineValidationTest(){
		
		baseURI="http://localhost";
		port=8084;
		
		String expectedStatusLine="HTTP/1.1 200 ";
		Response res = given()
		.get("/projects");
		String actualStatusLine=res.getStatusLine();
		Assert.assertEquals(expectedStatusLine, actualStatusLine);
	}
}
