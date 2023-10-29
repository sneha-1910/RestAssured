package CrudWithoutBdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleProjectAndValidate {
	
	
		@Test
		public void getSingleProjects() 
		{
			RequestSpecification reqs = RestAssured.given();
			Response res = reqs.get("http://rmgtestingserver:8084/projects/TY_PROJ_75248");
			
		    System.out.println(res.prettyPeek());
		    int statusCode=res.statusCode();
		    Assert.assertEquals(200, statusCode);
		    System.out.println("testCase Pass");	
		}
		
		@Test
		public void getDirect()
		{
			  Response res = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_75248");
			  res.then().log().all();//this will print both header and body
			  System.out.println(res.getStatusCode());
		}
		

}
