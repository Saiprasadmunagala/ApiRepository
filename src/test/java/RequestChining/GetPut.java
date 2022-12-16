package RequestChining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import RandomUtility.Randoom;
import io.restassured.http.ContentType;

public class GetPut {
	@Test
	public void getPutTest() {
		baseURI="http://localhost";
		port=8084;
	
	    String projId = when().get("projects/TY_PROJ_1008").jsonPath().get("projectId");
	    
	    Randoom ran= new Randoom();
		AddProjectPOJO pojo = new AddProjectPOJO("saiprasad", "AMS"+ran.getRanDomNum(), "Created", 5);
		
		//Second Put Request Started
	 given()
	 .pathParam("projectId", projId)
	 .body(pojo)
	 .contentType(ContentType.JSON)
	 .when()
	 .put("projects/{projectId}")
	 .then()
	 .assertThat()
	 .log().all()
	 .statusCode(200)
	 .time(Matchers.lessThan(2000L), TimeUnit.SECONDS);
}
}
