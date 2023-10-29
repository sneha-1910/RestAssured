package crudWithBDD;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponeBodyValidation {

	@Test
	public void srbv()
	{
		//prerequisites
		String Exp_data="TY_PROJ_17547";
		 baseURI="http://rmgtestingserver";
		 port=8084;
		 
	          Response res = when()
	                          .get("/projects");
	          
	         String actualdata = res.jsonPath().get("[0].projectId");
	         Assert.assertEquals(actualdata, Exp_data);
	         System.out.println("data verified");
	         
	         res.then().log().all();
          
	}
	
	
}
