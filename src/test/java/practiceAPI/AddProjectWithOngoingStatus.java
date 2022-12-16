package practiceAPI;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithOngoingStatus {
	@Test
public void AddProjectWithOngoingStatusTest() {
		
		Random ran = new Random();
		int random = ran.nextInt(100);
		//  create the body with json simple
		JSONObject job=new JSONObject();
		job.put("createdBy", "Sai"+random);
		job.put("projectName", "AMS"+random);
		job.put("status", "OnGoing");
		job.put("teamSize", 4);
		
		// preconditions (body and content type)
		RequestSpecification reqs=new RestAssured().given();
		reqs.body(job);
		reqs.contentType(ContentType.JSON);
		//Action
		Response response = reqs.post("http://localhost:8085/addProject");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
	}
	
	
}