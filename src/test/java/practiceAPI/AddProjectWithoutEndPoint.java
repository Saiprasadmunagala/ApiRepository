package practiceAPI;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithoutEndPoint {
	@Test
	public void AddProjectWithoutEndPointTest()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		//  create the body with json simple
		JSONObject job=new JSONObject();
		job.put("createdBy", "Sai"+random);
		job.put("projectName", "AMS"+random);
		job.put("status", "Completed");
		job.put("teamSize", 4);
		
		// preconditions (body and content type)
		RequestSpecification reqs=new RestAssured().given();
		reqs.body(job);
		reqs.contentType(ContentType.JSON);
		//Action
		Response response = reqs.post("http://localhost:8085");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);// Expected status code <201> but was <405> Method not allowed
		validate.log().all();
	}
	
}