package threeWayValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_Api;
import com.crm.GenericUtility.DataBaseUtility;

import GenericUtility.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class API_GUI_Database extends BaseClass_Api{

	@Test
	public void test() throws SQLException
	{
	//DataBaseUtility dlib=new DataBaseUtility();
	baseURI="http://rmgtestingserver";
	port=8084;
	
   JavaUtility jlib=new JavaUtility();
	
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "snehasp");
	
	String ProjName ="ssss1234567"+jlib.getRandomNo();
	 jobj.put("projectName", ProjName);
	jobj.put("status", "completed");
	jobj.put("teamSize", 5);
	
	given().body(jobj).contentType(ContentType.JSON)
	.when().post("/addProject")
		.then().log().all();
	
	//get the Id 
	
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.linkText("Projects")).click();
	WebElement ele1 = driver.findElement(By.xpath("//td[text()='"+ProjName+"']"));
	System.out.println(ele1.getText());

   String projID = driver.findElement(By.xpath("//td[text()='"+ProjName+"']/preceding-sibling::td")).getText();
    System.out.println(projID);
    driver.close();
	
    //3rd layer
    
       String query="select * from project;";
       String actData=dLib.executeQueryAndGetData(query, 1, projID);
       Assert.assertEquals(projID, actData);
       System.out.println("Test case is Pass");

	}	
	
}
