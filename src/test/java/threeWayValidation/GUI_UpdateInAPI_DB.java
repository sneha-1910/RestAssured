package threeWayValidation;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_Api;
import com.crm.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;

public class GUI_UpdateInAPI_DB extends BaseClass_Api {
	
	
	@Test
	public void test() throws SQLException
	{
	
	JavaUtility jlib = new JavaUtility();
     
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
      
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
		
		//update project
		   baseURI="http://rmgtestingserver";
			port=8084;
			
			  JavaUtility jLib=new JavaUtility();
				
				JSONObject jobj = new JSONObject();
				jobj.put("createdBy", "snehasp2");
				 jobj.put("projectName", ProjName);
				jobj.put("status", "Ongoing");
				jobj.put("teamSize", 5);
				
				given().pathParam("projID1", projID).body(jobj).contentType(ContentType.JSON)
				.when().put("/projects/{projID1}")
				.then().log().all();
	    
	//3rd layer
				
				  String query="select* from project;";
			        String actData= dLib.executeQueryAndGetData(query, 1, projID);
			        Assert.assertEquals(projID, actData);
			        System.out.println("Test case is Pass");

	}	
	
	
}
