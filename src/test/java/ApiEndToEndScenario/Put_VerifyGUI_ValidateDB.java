package ApiEndToEndScenario;

import static io.restassured.RestAssured.given;

import java.util.List;
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
import PojoClassGericUtility.AddProjectPOJO;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put_VerifyGUI_ValidateDB extends BaseClass{
	
	
	WebDriver driver;
	int num=jLib.getRanDomNum();
	@Test
	public void putRequest() throws Throwable {
		
	// step1 :- create pre requisites
AddProjectPOJO pojo=new AddProjectPOJO("saiPrasad", "ams"+jLib.getRanDomNum(), "Created", 4);
		
		// step 2 :- send the request 
		Response response = given()
		.body(pojo)  
		.contentType(ContentType.JSON)
		.when()
		.put(EndPointsLibrary.updateProject+"TY_PROJ_1202");
		
		// step3:- capture the project id 
		String expData = rLib.getJsonData(response, "projectId");
				Reporter.log(expData,true);
					System.out.println("-------Request Sended SuccessFullY--------");
					System.out.println("------Actual ProjectId Is : "+expData);
					
					
	// step 3:- verify the project name in GUI
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
					 List<WebElement> elements = driver.findElements(By.xpath("//table/descendant::tr/td[1]"));
					 
					 for (WebElement webElement : elements) {
						 
						 String actData=webElement.getText();
						 
						 if (expData.equalsIgnoreCase(actData)) {
							 
							 Assert.assertEquals(expData, actData);
							 System.out.println("-------yes the data is availble-----");
						 }
					}
					
					 
					/*
					List<WebElement> elements = driver.findElements(By.xpath("//table/descendant::tr/child::td[1]"));
					
					for (WebElement webElement : elements) {
						
						String actDataGui=webElement.getText();
						if(actDataGui.equalsIgnoreCase(expData)) {
						Assert.assertEquals(expData, actDataGui);
						
					
						System.out.println("---------yes data is verifyed in GUI : "+actDataGui+"------")	;
						}
					}
					
					*/
	  // Validate In Data Base
					String query="select * from project";
					
					String actDataDb = dLib.executeQuerryAndVerify(query, 1, expData);
					Assert.assertEquals(expData, actDataDb);
					System.out.println("----ProjectName Verifyed in DB : "+actDataDb);
}
}
