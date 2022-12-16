package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void pathParameterTest() {
		
		given()
		.pathParam("projectId", "TY_PROJ_1002")
		.when()
		.get("http://localhost:8084/projects/{projectId}")
		.then()
		.assertThat().log().all();
		
		
	}
	
}
