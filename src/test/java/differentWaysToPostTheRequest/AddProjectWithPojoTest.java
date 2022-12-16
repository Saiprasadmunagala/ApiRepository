package differentWaysToPostTheRequest;

import static org.testng.annotations.Test.*;

import org.testng.annotations.Test;

import PojoClassGericUtility.AddProjectPOJO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithPojoTest {
	@Test
	public void addProjectTest() {
		AddProjectPOJO apj = new AddProjectPOJO("sai", "ams125", "created", 4);
		baseURI="http://localhost:8084";
		port=8084;
	given()
	.body(apj)
	.contentType(ContentType.JSON)
	.when()
	.post("/porjects")
	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.log().all();
	}
}
