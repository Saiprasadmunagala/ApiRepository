package RequestChining;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import RandomUtility.Randoom;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostDeleteTest {
	
	@Test
	public void postDeleteTest() {
		
		baseURI="http://localhost";
		port=8084;
		
		Randoom ran=new Randoom();
		AddProjectPOJO pojo = new AddProjectPOJO("Sai", "AMS"+ran.getRanDomNum(), "Created", 4);
		
		Response response = given().body(pojo).contentType(ContentType.JSON).when().post("/addProject");
		String projId = response.jsonPath().get("projectId");
		
		given().pathParam("projectId", projId).when().delete("projects/{projectId}")
		.then()
		.assertThat()
		.statusCode(204)
		.time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
		
	}
	
}
