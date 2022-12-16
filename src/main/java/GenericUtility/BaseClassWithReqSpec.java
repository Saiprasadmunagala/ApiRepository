package GenericUtility;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class BaseClassWithReqSpec {
	public RequestSpecification requestSpec;
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public javaUtility jLib=new javaUtility();
	public RestAssuredLibyary rLib=new RestAssuredLibyary();
	public ExcelUtilityAPI eLib=new ExcelUtilityAPI();
	
	
	@Test
	public void requestSpecBuilder() throws Throwable{
		dLib.closeDB();
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		requestSpec= builder.build();
		
	}
	
}
