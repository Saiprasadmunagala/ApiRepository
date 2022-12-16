package RequestChining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import RandomUtility.Randoom;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PostGetTest {
	
	@Test
	public void postGetTest() {
		baseURI="http://localhost";
		port=8084;
		Randoom ran= new Randoom();
		AddProjectPOJO pojo=new AddProjectPOJO("SaiPrasad", "SaiPrasad"+ran.getRanDomNum(), "Created", 4);
	    Response response = given().body(pojo).contentType(ContentType.JSON).when().post("/addProject");
	    String projId = response.jsonPath().get("projectId");
	    given()
	    .pathParam("projectId", projId)
	    .when()
	    .get("projects/{projectId}")
	    .then()
		.assertThat().log().all()
		.statusCode(200)
		.time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
	}
	
}
