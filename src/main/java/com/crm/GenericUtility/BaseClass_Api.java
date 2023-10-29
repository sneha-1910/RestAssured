package com.crm.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass_Api {

	WebDriver driver;

	public FileUtility fLib=new FileUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;

	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dLib.connectToDB();

		//	reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
		//	.setContentType(ContentType.JSON).build();
		//	
		//    resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}

/*	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException, Throwable 
	{
		//String BROWSER = fLib.readDataFromPropertyFile("browser");


		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://rmgtestingserver:8084");
		Thread.sleep(2000);

		System.out.println("----Launch the Broswer----");
		wLib.maximizeWindow(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void cofig_BM()
	{

		System.out.println("login to application");
	}
	@AfterMethod(alwaysRun = true)
	public void Config_AM()
	{    
		System.out.println("logout from application");
	}


	@AfterClass(alwaysRun = true)
	public void Config_AC()
	{
		driver.quit();
		System.out.println("----Close the Browser----");
	}*/

	@AfterSuite
	public void asConfig() throws SQLException 
	{
		dLib.closeDB();
	}
}