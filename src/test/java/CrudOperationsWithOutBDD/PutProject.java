package CrudOperationsWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutProject {
	
	@SuppressWarnings("unchecked")
	@Test
	public void putProjectTest() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Sai1");
	jobj.put("projectName", "Oams1");
	jobj.put("status", "201");
	jobj.put("teamSize", 4);
	
	// preconditions request 
	RequestSpecification reqs=new RestAssured().given();
	reqs.body(jobj);
	reqs.contentType(ContentType.JSON);
	// action 
	Response responce=reqs.put("http://localhost:8084/projects/TY_PROJ_802");
	ValidatableResponse validate= responce.then();
	validate.contentType(ContentType.JSON);
	validate.statusCode(200);
	validate.log().all();
	
	
	}	
}
//projects
/*TY_PROJ_802
 
 job.put("createdBy", "Sai");
		job.put("projectName", "Oams");
		job.put("status", "201");
		job.put("teamSize", 4);
 
 */