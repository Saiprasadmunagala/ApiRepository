package CrudOprationsWithBDD;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetProject {
	
	@Test
	public void getProjectTest() {
		
		baseURI = "http://localhost";
		
		
		when()
		     .get("/projects/TY_PROJ_1004")
		 .then()
		      .assertThat()
		            .contentType(ContentType.JSON).log().all();
		
	}
	
}
