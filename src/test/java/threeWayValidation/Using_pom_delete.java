package threeWayValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_Api;
import com.crm.GenericUtility.EndPointLibrary;
import com.crm.GenericUtility.IpathConstants;

import POM.CreateProject_page;
import POM.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Using_pom_delete extends BaseClass_Api{

	@Test
	public void test() throws InterruptedException, SQLException
	{
		WebDriverManager.firefoxdriver().setup();
		 WebDriver driver=new FirefoxDriver();
		   
		   driver.get(IpathConstants.appURL);
		   
	     	Login_Page log = new Login_Page(driver);
	     	log.Login(IpathConstants.appUserName, IpathConstants.appPassword);
	        String ProjectName="tyss"+jLib.getRandomNo();
	     	CreateProject_page cp = new CreateProject_page(driver);
	     	cp.Project(ProjectName, "sneha", "Created");
	     	String proId = cp.ProjectID(driver, ProjectName);
	     	Thread.sleep(2000);
	     	driver.close();
	     	
	     	//2nd layer
	     	 baseURI=IpathConstants.appURL;
	         given().pathParam("ProID1", proId)
	         .when().delete(EndPointLibrary.deleteProject+"{ProID1}")
	         .then().statusCode(204).log().all();
	         
	         
	       //3rd layer
	         String query="select* from project;";
	         String actData=dLib.executeQueryAndGetData(query, 1,proId);
	         Assert.assertEquals(proId, actData);
	         System.out.println("Test case is pass");

	}
}
