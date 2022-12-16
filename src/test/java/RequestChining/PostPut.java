package RequestChining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import RandomUtility.Randoom;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostPut {
	
	@Test
	public void postPutTest() {
		
		baseURI="http://localhost";
		port=8084;
		
		Randoom ran= new Randoom();
		AddProjectPOJO pojo = new AddProjectPOJO("saiprasad", "AMS"+ran.getRanDomNum(), "Created", 4);
		
		 Response response = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		 String proId = response.jsonPath().get("projectId");
		 
		 Randoom ran1= new Randoom();
			AddProjectPOJO pojo1 = new AddProjectPOJO("saiprasad", "AMS"+ran.getRanDomNum(), "Created", 5);
		 given()
		 .pathParam("projectId", proId)
		 .body(pojo1)
		 .contentType(ContentType.JSON)
		 .when()
		 .put("/projects/{projectId}")
		 .then()
		 .assertThat()
		 .log().all()
		 .statusCode(200)
		 .time(Matchers.lessThan(2000L), TimeUnit.SECONDS);
	}
	
}
