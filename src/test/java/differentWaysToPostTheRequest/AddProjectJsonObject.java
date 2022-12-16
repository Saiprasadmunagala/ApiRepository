package differentWaysToPostTheRequest;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectJsonObject {
	
	@Test
	public void addProjectWithJsonObject() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Sai");
	jobj.put("projectName", "Ams12345");
	jobj.put("status", "created");
	jobj.put("teamSize", 4);
	baseURI="http://localhost";
	port= 8084;
	given()
	.body(jobj)
	.contentType(ContentType.JSON)
	.when()
	.post("/addProject")
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.log().all();
	}
}
