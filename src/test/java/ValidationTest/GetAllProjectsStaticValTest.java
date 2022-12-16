package ValidationTest;

import javax.annotation.meta.When;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllProjectsStaticValTest {
	
	@Test
	public void getAllProjectsTest() {
		String expectedPname="Oams17";
      Response responce = when().get("http://localhost:8084/projects/");
      String actualPname=responce.jsonPath().getString("[0].projectName");
      Assert.assertEquals(actualPname, expectedPname);
      
	}
	
	
}
