package crudWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CReate {
	


	@Test
	public void CRProject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
       JavaUtility jlib=new JavaUtility();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "snehasp");
		jobj.put("projectName", "ssss1234567"+jlib.getRandomNo());
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		// step1 preCondition
	       given()
	       .body(jobj)
	       .contentType(ContentType.JSON)
	       
	   // step2 actions
	       .when()
	       .post("/addProject")
	       
	   // step3 validation
	      .then()
	      .assertThat()
	      .contentType(ContentType.JSON)
	      .log()
	      .all();      
		
	}

	
	@Test
	public void getAllProjects()
	{
	   baseURI="http://rmgtestingserver";
	   port=8084;
	   
	   when()
	   .get("/projects")
	   
	   //validation
	   .then()
	   .assertThat()
	   .contentType(ContentType.JSON)
	   .statusCode(200)
	   .log()
	   .all();   
	}
	
	@Test
	public void singleGet()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_77064")
		
		//validation
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();	
	}
	
	@Test
	public void put() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
			
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "snehaaaa");
			jobj.put("projectName", "ssss123456778");
			jobj.put("status", "completed");
			jobj.put("teamSize", 9);
			
			given()
			.body(jobj) 
			.contentType(ContentType.JSON)
			
			.when()
			.put("/projects/TY_PROJ_77064")
			
			.then()
			.statusCode(200)
			.log()
			.all();	
	}
	
	@Test
	public void delete() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.delete("/projects/TY_PROJ_75437")
		
		.then()
		.statusCode(204)
		.log()
		.all();
	}
			
		
}
