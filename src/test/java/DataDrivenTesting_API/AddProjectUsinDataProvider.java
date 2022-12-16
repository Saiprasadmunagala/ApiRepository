package DataDrivenTesting_API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtilityAPI;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import PojoClassGericUtility.AddProjectPOJO;
import io.restassured.http.ContentType;

public class AddProjectUsinDataProvider {

	@Test (dataProvider = "TestBody")
	public void addProjectTest(String createdBy,String projectName, String status, int teamSize) throws Throwable {
		AddProjectPOJO poj=new AddProjectPOJO(createdBy,projectName,status,teamSize);
		
		given()
		     .body(poj)
		     .contentType(ContentType.JSON)
		  .when()
		  .post("http://localhost:8084/addProject")
		  .then()
		     .assertThat()
		        .contentType(ContentType.JSON)
		        .log().all();
	}
	
	
	@DataProvider
	public Object[][] TestBody() throws Throwable, IOException {
		ExcelUtilityAPI eLib=new ExcelUtilityAPI();
		String createdBy = eLib.getExcelData("Sheet3", 1, 0);
		String projectName = eLib.getExcelData("Sheet3", 1, 1);
		String status = eLib.getExcelData("Sheet3", 1, 2);
		int teamSize = eLib.getExcelDataInt("Sheet3", 1, 3)-48;
		
		String createdBy1 = eLib.getExcelData("Sheet3", 2, 0);
		String projectName1 = eLib.getExcelData("Sheet3", 2, 1);
		String status1 = eLib.getExcelData("Sheet3", 2, 2);
		int teamSize1 = eLib.getExcelDataInt("Sheet3", 2, 3)-48;
		
		Object[][] obj=new Object[2][4];
		obj[0][0]=createdBy;
		obj[0][1]=projectName;
		obj[0][2]=status;
		obj[0][3]=teamSize;
		
		obj[1][0]=createdBy1;
		obj[1][1]=projectName1;
		obj[1][2]=status1;
		obj[1][3]=teamSize1;
		return obj;
	}
}