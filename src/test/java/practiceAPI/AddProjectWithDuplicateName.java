package practiceAPI;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithDuplicateName {
	
	@Test
	public void AddProjectWithDuplicateNameTest()
	{
		JSONObject job=new JSONObject();
		job.put("createdBy", "Sai");
		job.put("projectName", "Ams");
		job.put("status", "Completed");
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