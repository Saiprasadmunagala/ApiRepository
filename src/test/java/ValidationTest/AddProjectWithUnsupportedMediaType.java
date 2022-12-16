package ValidationTest;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectWithUnsupportedMediaType {
@Test
public void gaddProjectWithUnsupportedMediaTypeTest()
{
	Random random=new Random();
	int ran=random.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Sai"+ran);
	jobj.put("projectName", "Tiger" +ran);
	jobj.put("status", "created");
	jobj.put("teamsize", 10);
	baseURI = "http://localhost";
	port=8084;
	String expectedContent="application/json";
	String expectedStatusLine="HTTP/1.1 500 ";
	
	given()
	     .body(jobj)
	     .contentType(ContentType.XML)
	     .accept(ContentType.XML);
	     
	     Response res = given()
	 	.post("/addProject");
	       
	     String actualContent = res.getContentType();
	 	String actualstatusLine = res.getStatusLine();
	 	res.then().log().all();
	 	Assert.assertEquals(expectedContent, actualContent);
	 	Assert.assertEquals(actualstatusLine, expectedStatusLine);
	
	
	
	
	
}	

}