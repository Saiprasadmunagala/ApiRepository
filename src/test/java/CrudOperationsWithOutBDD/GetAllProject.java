package CrudOperationsWithOutBDD;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllProject {
	
	@Test
	public void getAllProjectTest() {
RequestSpecification reqs=new RestAssured().given();
		
		Response responce = reqs.get("http://localhost:8084/projects");
		ValidatableResponse validate = responce.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
		
		
	}
	
	
}
