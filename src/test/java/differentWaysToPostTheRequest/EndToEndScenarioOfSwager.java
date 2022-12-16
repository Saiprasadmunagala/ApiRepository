package differentWaysToPostTheRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.awt.PopupMenu;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class EndToEndScenarioOfSwager {
	
	@Test
	public void EndToEndScenarioOfSwagerTest() {
	
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
