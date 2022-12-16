package ApiEndToEndScenario;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import static io.restassured.RestAssured.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_VerifyGUI_ValidateDb extends BaseClass{
	WebDriver driver;
	
	@Test
	public void deleteRequest() throws Throwable {
		
		//Verify in GUI
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("http://localhost:8084/");
				driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				driver.findElement(By.linkText("Projects")).click();
				 String expData = driver.findElement(By.xpath("//table/descendant::tr[2]/td[1]")).getText();
		
		//delete the project request
		when()
		.delete(EndPointsLibrary.deleteProject+expData);
		
	
		
	
		// step 4 :- validate the id in DataBase
				String query="select * from project";
				String actData = dLib.executeQuerryAndVerify(query, 1, expData);
				Assert.assertNotEquals(expData,actData);
}
}