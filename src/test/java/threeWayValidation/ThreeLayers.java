package threeWayValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_Api;
import com.crm.GenericUtility.DataBaseUtility;
import com.crm.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class ThreeLayers extends BaseClass_Api {
	@Test
	public void threeLayers() throws SQLException
	{
		//DataBaseUtility dLib=new DataBaseUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.linkText("Projects")).click();
		// it is working---driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		String ProjName="SCM_9"+jlib.getRandomNo();

		driver.findElement(By.name("projectName")).sendKeys(ProjName);
		driver.findElement(By.name("createdBy")).sendKeys("Sneha");
		WebElement dropdown=driver.findElement(By.xpath("//option[text()='Select Value']/.."));
		Select sel=new Select(dropdown);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement ele1 = driver.findElement(By.xpath("//td[text()='"+ProjName+"']"));
				System.out.println(ele1.getText());
		
       String projID = driver.findElement(By.xpath("//td[text()='"+ProjName+"']/preceding-sibling::td")).getText();
			System.out.println(projID);	
       
       //2nd Layer
       baseURI="http://rmgtestingserver";
		port=8084;
       given().pathParam("projID1",projID)
		.when().get("/projects/{projID1}")
		.then().log().all();
				
         //3rd layer
        
         String query="select* from project;";
	        String actData= dLib.executeQueryAndGetData(query, 1, projID);
	        Assert.assertEquals(projID, actData);
	        System.out.println("Test case is Pass");
	}
}
