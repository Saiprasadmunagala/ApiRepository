package ApiEndToEndScenario;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.List;

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
import static io.restassured.RestAssured.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_verifyInGUI_ValidateDB extends BaseClass {
	
	WebDriver driver;

	@Test(priority = 1)

	
public void getRequest() throws Throwable {
		
		Response response = when()
		.get(EndPointsLibrary.getAllProject);//.jsonPath().get("ProjectId");
		
		// step3:- capture the project id 
		String expData = rLib.getJsonData(response, "[0].projectId");
				Reporter.log(expData,true);
				
		

	// verify the project in GUI
	
				WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();	
		 driver.get("http://localhost:8084/");
		 Thread.sleep(1000);
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()=\"Sign in\"]")).click();
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
		
		
   // ValidateDB
		
		String query = "select * from project";
		String actData = dLib.executeQuerryAndVerify(query, 1, expData);
		
		Assert.assertEquals(actData, expData);
		System.out.println(actData);
		
	}
}