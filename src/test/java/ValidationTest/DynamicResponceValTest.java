package ValidationTest;



import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class DynamicResponceValTest {
	
	
	@Test
	public void getAllProjectsTest() {
		baseURI="http://localhost";
		port=8084;
		String expectedid="TY_PROJ_1413";
		Response responce = when().get("/projects");
		List<String> actId = responce.jsonPath().get("projectId");
		Boolean flag=false;
		
		for(String id:actId) {
			if(id.equalsIgnoreCase(expectedid)) {
                  System.out.println("project is found");	
                  flag=true;
			}
			
		}
		
		Assert.assertTrue(flag);
	}
	
	
}
