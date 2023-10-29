package crudWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class Dynamin_ResponseBodyValidation {

	@Test
	public void drbv()
	{
		//prerequisites
		String Exp_data="TY_PROJ_17530";
		 baseURI="http://rmgtestingserver";
		 port=8084;
		
		 //action
		       Response res = when()
		             .get("/projects");
		       
		  //validation
		       boolean flag=false;
		     List<String> proIDS = res.jsonPath().get("projectId");
		     for (String projectId : proIDS) 
		     {
		    	 if(projectId.equalsIgnoreCase(Exp_data))
		    	 {
		    		 flag = true; 
		    	 }
				
			}
		  
		     Assert.assertTrue(flag);
		     System.out.println("data verified");
		     
		     res.then().log().all();
		
		
}
}