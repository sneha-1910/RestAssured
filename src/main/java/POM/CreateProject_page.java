package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;

public class CreateProject_page extends WebDriverUtility {
   
	JavaUtility jLib=new JavaUtility();
	 
	@FindBy(linkText = "Projects")
	private WebElement Project_Button;
	
	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement Create_proj_btn;
	
	@FindBy(name = "projectName")
	private WebElement project_name;
	
	@FindBy(name = "createdBy")
	private WebElement created_by;
	
	@FindBy(xpath="//option[text()='Select Value']/..")
	private WebElement dropdown;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement Add_project;
	
	
	//initialization
	
	public CreateProject_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	
	public WebElement getProject_Button() {
		return Project_Button;
	}

	public WebElement getCreate_proj_btn() {
		return Create_proj_btn;
	}

	public WebElement getProject_name() {
		return project_name;
	}

	public WebElement getCreated_by() {
		return created_by;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getAdd_project() {
		return Add_project;
	}
	
	//business library
	public void Project(String ProjectName,String CreatedBy,String text)
	{
		Project_Button.click();
		Create_proj_btn.click();
		project_name.sendKeys(ProjectName);
		created_by.sendKeys(CreatedBy);
		
		select(text, dropdown);
		Add_project.click();			
	}
	
	public String ProjectID(WebDriver driver,String ProjectName)
	{
		String ProjectID=driver.findElement(By.xpath("//td[text()='"+ProjectName+"']/preceding-sibling::td")).getText();
		return ProjectID;
	}
	

}
