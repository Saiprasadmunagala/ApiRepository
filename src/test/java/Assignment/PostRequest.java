package Assignment;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	
	  /* public static long id;
		
		 baseURI="https://petstore.swagger.io/v2";
	
	@Test
public void post() {
		
		
		JSONObject obj=new JSONObject();
		baseURI="https://petstore.swagger.io/v2";
		{
   obj.put("id", 0);
   obj.put("petId", 123);
   obj.put("quantity", 15);
   obj.put("shipDate", "2022-10-19T05:19:03.537Z");
   obj.put("status", "placed");
   obj.put("password", "sai");
   obj.put("complete", true);
		}
		 
		Response res = given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("/pet");
		   id=res.jsonPath().get("id");
		//	actUserName = rLib.getJsonData(res, "petId");
		//	Reporter.log(actUserName,true);
			System.out.println(id);
		res.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}*/
}
