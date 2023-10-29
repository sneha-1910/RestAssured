package threeWayValidation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validation {

	@Test
	public void test() throws InterruptedException
	{
		JavaUtility jLib=new JavaUtility();
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("tyss");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sneha"+jLib.getRandomNo());
		
		WebElement ele = driver.findElement(By.xpath("//form[@action='#']//descendant::select[@name='status']"));
		Select sal=new Select(ele);
		sal.selectByVisibleText("On Gogin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer']//following-sibling::input[@type='submit']")).click();
		
		
	
	}	
}