package practiceAPI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectWithUnsupportedMediaType {
	
	@Test
	public void GetProjectWithUnsupportedMediaTypeTest()
	{
		baseURI="http://localhost";
		port=8085;
		
		when()
		   .get("/projects/TY_PROJ_805")
		.then()
		    .assertThat()
		            .contentType(ContentType.XML)		            
		            .statusCode(200)
		            .log().all();
		
	}

}