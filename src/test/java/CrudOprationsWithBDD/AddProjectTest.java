package CrudOprationsWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest {
	
	

	@Test
	public void creatProjectTest() {
		Random ran=new Random();
		int random = ran.nextInt(100);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "saiprasad"+random);
		jobj.put("projectName", "Oams"+random);
		jobj.put("status", "201");
		jobj.put("teamSize", 4);
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		   .body(jobj)
		   .contentType(ContentType.JSON)
		.when()
		   .post("/addProject")
		.then()
		      .assertThat()
		           .contentType(ContentType.JSON).log().all();
		   
		
	}
	
	
}
