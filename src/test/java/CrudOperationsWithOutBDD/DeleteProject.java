package CrudOperationsWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProject {
	
	@Test
	public void deleteProjectTest() {
		//preConditions
		RequestSpecification reqs = new RestAssured().given();
		//Action
		Response rsesponce = reqs.delete("http://localhost:8084/projects/TY_PROJ_402");
		ValidatableResponse validate = rsesponce.then();
		validate.assertThat().statusCode(204);
		validate.log().all();
	}
	
}
