package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	//declaration
	@FindBy(xpath="//input[@id='usernmae']")
	private WebElement UserName;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement Password;
	
	@FindBy(xpath ="//button[text()='Sign in']")
	private WebElement SignIn_Button;
	
	//initialization
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSignIn_Button() {
		return SignIn_Button;
	}
	
	
	//business Library
	 public void Login(String USERNAME, String PASSWORD) throws InterruptedException 
	 {
		 getUserName().sendKeys(USERNAME);
		 getPassword().sendKeys(PASSWORD);
		 getSignIn_Button()
		 .click();	
		 Thread.sleep(3000);
	 }
	
	
}
