package CrudWithoutBdd;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void test() 
	{
		JavaUtility jlib=new JavaUtility();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "snehasp");
		jobj.put("projectName", "ssss1234567"+jlib.getRandomNo());
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response req = reqs.post("http://rmgtestingserver:8084/addProject");
		
		//System.out.println(req.asString());
		//System.out.println(req.prettyPrint());
		System.out.println(req.prettyPeek());
		System.out.println(req.getStatusCode());
		
	}
	
	// get all projects 
	@Test
	public void getALLProjects()
	{
		Response res = RestAssured.get("http://rmgtestingserver:8084/projects");
		res.then().log().all();
		int statusCode=res.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println("pass");
	}
	
	// edit project
	@Test
	public void UpdateprojectUsingPUT()
	{
	
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "snehaspp");
		jobj.put("projectName", "ssss12345678");
		jobj.put("status", "completed");
		jobj.put("teamSize", 6);
		
		
	     RequestSpecification reqs = RestAssured.given();
	     reqs.body(jobj);
	     reqs.contentType(ContentType.JSON);
	     Response res = reqs.put("http://rmgtestingserver:8084/projects/TY_PROJ_75248");
	   
	     System.out.println(res.statusCode()+"=statusCode");
	     System.out.println(res.prettyPeek());
}
	
	 @Test
	 public void Delete() 
	 {
		 Response res = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_75248");
		 System.out.println(res.contentType());
		 System.out.println(res.statusCode());
 }
		
}
