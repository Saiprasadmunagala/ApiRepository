package practiceAPI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectWithWrongEndPoint {
@Test
public void AddProjectWithWrongEndPointTest()
{
	Random random=new Random();
	int ran=random.nextInt(100);
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Sai"+ran);
	jobj.put("projectName", "Tiger" +ran);
	jobj.put("status", "created");
	jobj.put("teamsize", 10);
	baseURI = "http://localhost";
	port=8085;
	
	given()
	     .body(jobj)
	     .contentType(ContentType.JSON)
	     
	.when()
	       .post("/addUser1")
	       
	.then()
	      .assertThat()
	           .contentType(ContentType.JSON)
	           .statusCode(200)//Expected status code <200> but was <404>.
               .log().all();
}
	

}