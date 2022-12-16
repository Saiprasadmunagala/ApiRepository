package Assignment;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PutRequest {
	
	
	/*
	
	@Test(priority = 2)
	public void getRequest() {
		//get request
		Response get = given().get("https://petstore.swagger.io/user/"+actUserName+"");
		
		String actFirstName  = get.jsonPath().get("firstName");
		//String actFirstName  = rLib.getJsonData(get, "firstName");
		Assert.assertEquals(expFirstName, actFirstName);
		get.then().statusCode(200);
		Reporter.log(actFirstName,true);
		
	}	
	
	}*/
}
