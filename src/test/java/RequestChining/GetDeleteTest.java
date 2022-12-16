package RequestChining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetDeleteTest {
	
	@Test
	public void getDeleteTest() {
		
		baseURI="http://localhost";
		port=8084;
	
	    String projId = when().get("projects/TY_PROJ_1005").jsonPath().get("projectId");
	    
	    given().pathParam("projectId", projId)
	    .when().delete("/projects/{projectId}")
	    .then()
	    .assertThat().log().all()
		.statusCode(204)
		.time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
		
	}
	
}
