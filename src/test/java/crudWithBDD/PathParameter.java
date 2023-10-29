package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

	
	@Test
	public void get()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given().pathParam("projID","TY_PROJ_75911")
		.when().get("/projects/{projID}")
		.then().log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
