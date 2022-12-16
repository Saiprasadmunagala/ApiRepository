package MpsAssignment;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ContentTypeSubTypeExtractor;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.io.File;

public class MpsAssignment {
	
	@Test
	public void getRequestTest() {
		//baseURI="http://presensegesti-env-test";
		baseURI="https://petstore.swagger.io/v2";
		//port=8084;
		File file=new File("./data/MpsAssignment.json");
		/*JSONObject bod=new JSONObject();
		bod.put("ClassCode", "CEO-123");
		bod.put("SectionCode", "ABC-12");
		bod.put("Year", 2);
		bod.put("semister", 1);
		bod.put("StartingRollNum", "ABC-100");
		bod.put("EndingRollNum", "ABC-200");*/
		/**/
		 io.restassured.response.Response res = given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		//.post("classes/addClass");
		.post("/store/order");
		Object pid = res.jsonPath().get("id");
		res.then()
		.log()
		.all()
		.and()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
		given()
		.pathParam("oid", pid)
		.when()
		.get("/store/order/{oid}")
		.then()
		.log()
		.all()
		.and()
		.assertThat().log().all()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3000l))
		.statusCode(200);
		
		
		given()
		.pathParam("cid", pid)
		.when()
		.delete("/store/order/{cid}")
		.then()
		.log().all()
		.statusCode(200);
	}
	
}
