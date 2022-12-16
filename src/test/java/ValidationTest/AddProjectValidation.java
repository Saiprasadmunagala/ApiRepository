package ValidationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddProjectValidation {
	
	@Test
		public void addProjectValidationTest() {
		baseURI="http://localhost";
		port=8084;
		AddProjectPOJO apj = new AddProjectPOJO("Sai", "ASDFG1", "Created", 4);
		
		Response res = given().post("/addProject");
		String body=res.getBody().asString();
		String expectedPname="ASDFG1";
		given().then().log().all();
		String actualPname=res.jsonPath().getString("[0].projectName");
		Assert.assertEquals(actualPname, expectedPname);
	}
}
