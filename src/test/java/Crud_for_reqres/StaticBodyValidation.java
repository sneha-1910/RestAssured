package Crud_for_reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class StaticBodyValidation {

	
   @Test
   public void sbv()
   {
	   baseURI="https://reqres.in";
	   int exp_data=7;
	    Response res = when().get("/api/users?page=2");
	    
	    int actualDtaa = res.jsonPath().get("data[0].id");
	    Assert.assertEquals(actualDtaa, exp_data);
	    System.out.println("data verified");
	    res.then().log().all();
   }
   
   @Test
   public void dynamic() 
   {
	   baseURI="https://reqres.in";
	   int exp_data=7;
	    Response res = when().get("/api/users?page=2");
	    
	    
	    boolean flag=false;
	List<Integer> Ids=res.jsonPath().get("data.id");
	for (Integer Req_ids : Ids) 
	{
		flag=true;
	}
	
	Assert.assertTrue(flag);
	System.out.println("data verified");
   }
   
   
   @Test
   public void dynam() 
   {
	   baseURI="https://reqres.in";
	   String exp_data="michael.lawson@reqres.in";
	    Response res = when().get("/api/users?page=2");
	    
	    
	    boolean flag=false;
	List<String> email=res.jsonPath().get("data.email");
	for (String Req_mail : email) 
	{
		flag=true;
	}
	
	Assert.assertTrue(flag);
	System.out.println("data verified");

   }
	
}
