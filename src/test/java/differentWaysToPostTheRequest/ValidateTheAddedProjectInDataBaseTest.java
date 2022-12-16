package differentWaysToPostTheRequest;



import javax.sound.sampled.Port;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class ValidateTheAddedProjectInDataBaseTest {
	
	@Test
		public void validateTheAddedProjectInDataBaseTest() {
			
		baseURI="http:/localhost";
		port= 8084;
		
	    when()
		   .get("/projects")
		.then()
		    .assertThat()
		         .contentType(ContentType.JSON)
		         .statusCode(201)
		         .log().all();
		
	}
}
