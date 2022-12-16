package ApiEndToEndScenario;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import GenericUtility.javaUtility;
import PojoClassGericUtility.AddProjectPOJO;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_UpdateGUI_ValidateInDb extends BaseClass{
	
	WebDriver driver;
	Random  r=new Random();
	String ranString=r.toString();
	@Test
	public void putRequest() throws Throwable {
		
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
					System.out.println("-------Request Sended SuccessFullY--------");
					System.out.println("------Actual ProjectId Is : "+expData);
					
					
	// step 3:- verify the project name in GUI
					
					String expName="GUIUpdate"+ranString;
					System.out.println(expName);
					
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					// launch the browser
					driver.get("http://localhost:8084/");
					driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
					driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
					driver.findElement(By.xpath("//button[text()='Sign in']")).click();
					driver.findElement(By.linkText("Projects")).click();
					 
					 Thread.sleep(1000);
					 driver.findElement(By.linkText("Projects")).click();
					 
					
					driver.findElement(By.xpath("//table/descendant::tr/td[text()='"+expData+"']/parent::tr/descendant::i[text()='']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//label[text()='Project Name']/following-sibling::input")).sendKeys(expName);
					driver.findElement(By.xpath("//input[@value='Save']")).click();
					Thread.sleep(3000);
					System.out.println("-------yes the data is updated-----");
						 
					
					
					 
				
	  // Validate In Data Base
					String query="select * from project";
					
					String actNameDb = dLib.executeQuerryAndVerify(query, 4, expData);
					Assert.assertEquals(expName, actNameDb);
					System.out.println("----ProjectName Verifyed in DB : "+actNameDb);
}
}

