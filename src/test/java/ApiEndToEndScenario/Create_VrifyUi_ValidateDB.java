package ApiEndToEndScenario;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import PojoClassGericUtility.AddProjectPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Create_VrifyUi_ValidateDB extends BaseClass {
	
	@Test
	public void postRequest() throws Throwable {
		
		// step1 :- create pre requisites
		AddProjectPOJO pojo=new AddProjectPOJO("saiPrasad", "ams"+jLib.getRanDomNum(), "Created", 4);
		
		// step 2 :- send the request 
		Response response = given()
		.body(pojo)  
		.contentType(ContentType.JSON)
		.when()
		.post(EndPointsLibrary.creatProject);
		
		// step3:- capture the project id 
		String expData = rLib.getJsonData(response, "projectId");
				Reporter.log(expData,true);
							
		// step 4 :- validate the id in DataBase
				String query="select * from project";
				String actData = dLib.executeQuerryAndVerify(query, 1, expData);
				Assert.assertEquals(expData,actData);
				
	}
}
