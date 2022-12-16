package GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public javaUtility jLib=new javaUtility();
	public RestAssuredLibyary rLib=new RestAssuredLibyary();
	public ExcelUtilityAPI eLib=new ExcelUtilityAPI();
	
	
	@BeforeSuite
	public void connectToDB() throws SQLException {
		
		dLib.connectDB();
		baseURI="http://localhost";
		port= 8084;
		System.out.println("--------Connected To DataBase----------");
	}
	@AfterSuite
	public void closeDB() throws SQLException {
		
		dLib.closeDB();
		System.out.println("--------DataBase Connection Closed----------");
	}
}
