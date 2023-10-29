package crudWithBDD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pojo.Pojoclass_createProject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProvider_POST
{
	@DataProvider(name="data")
	public Object[][] getDAta()
	{
		Object[][] data=new Object[3][4];
		
		data[0][0]="Sneha";
		data[0][1]="586";
		data[0][2]="Ongoing";
		data[0][3]=10;
		
		data[1][0]="Sne";
		data[1][1]="58610";
		data[1][2]="Ongoing";
		data[1][3]=10;
		
		data[2][0]="Sonu";
		data[2][1]="58619";
		data[2][2]="Ongoing";
		data[2][3]=10;
		
		return data;  
	
	}
	
@Test(dataProvider="data")
 
public void Createproject(String createdBy,String projectName,String status,int teamSize)
{
	Pojoclass_createProject pc=new Pojoclass_createProject(createdBy,projectName,status,teamSize);
			
		baseURI="http://rmgtestingserver";
	    port=8084;
	    
			given()
			.body(pc)
			.contentType(ContentType.JSON)
			
			.when()
			.post("/addProject")
			
			.then().log().all();
					
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
