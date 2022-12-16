package ApiEndToEndScenario;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.RestAssuredLibyary;
import PojoClassGericUtility.AddProjectPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Assignement_1{
	
	RestAssuredLibyary rLib=new RestAssuredLibyary();
	String expFirstName="Sai";
	String actUserName ;
	
	@Test (priority = 1)
	public void post() {
			
		
		
		JSONObject pojo=new JSONObject();
		{
   pojo.put("id", 0);
   pojo.put("username", "Sai");
   pojo.put("firstName", "Sai");
   pojo.put("lastName", "Munagala");
   pojo.put("email", "saiprasad@gmail.com");
   pojo.put("password", "sai");
   pojo.put("phone", "9595959595");
   pojo.put("userStatus", 1);
		}
		 
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("https://petstore.swagger.io/user/createWithArray");
		actUserName=res.jsonPath().get("username");
		//	actUserName = rLib.getJsonData(res, "username");
			Reporter.log(actUserName,true);
		res.then()
		.assertThat().statusCode(201);
		
		
	}
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
		@Test(priority = 3)
		public void putRequest() {
		//put Request
			JSONObject pojo=new JSONObject();
			{
	   pojo.put("id", 199);
	   pojo.put("username", "Sai");
	   pojo.put("firstName", "Saiprasad");
	   pojo.put("lastName", "Munagala");
	   pojo.put("email", "prasad.ms@gmail.com");
	   pojo.put("password", "Saiprasad");
	   pojo.put("phone", "8585858585");
	   pojo.put("userStatus", 1);
			}
			 
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.put("https://petstore.swagger.io/user/"+actUserName+"")
		.then()
		.assertThat()
		.statusCode(405);
		
		}
		@Test(priority = 4)
		public void deleteRequest() {
		
		//Delete Request
		given()
		.delete("https://petstore.swagger.io/user/"+actUserName+"")
		
		.then()
		.assertThat().statusCode(405);// actual status 404
		
		}
		
	
}
