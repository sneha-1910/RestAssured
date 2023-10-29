package Crud_for_reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

public class PostRequestUsing_Object {

	@Test
	public void post()
	{
		baseURI="https://reqres.in";
		JSONObject jobj = new JSONObject();
				jobj.put("name", "sneha");
				jobj.put("job", "Trainee");
				
			given()
	         .body(jobj)
	         .contentType(ContentType.JSON)
	         
	         .when()
	         .post("/api/users")
	         .then().statusCode(201).log().all();
	}
	
	
	@Test
	public void POst_File()
	{
		baseURI="https://reqres.in";
		
		File fl=new File(".\\Reqres_Post.json");
		
		given()
		.body(fl)
		.contentType(ContentType.JSON)
		
		.when().post("/api/users")
		.then().log().all();			
	}
	
	@Test
	public void POST_Map() 
	{
		baseURI="https://reqres.in";
		HashMap map=new HashMap();
		{
			map.put("name", "sneha");
			map.put("job", "leader");	
		}
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when().post("/api/users")
		.then().log().all();
		
}
	
	
	@Test
	public void Post_pojo()
	{
		baseURI="https://reqres.in";
		Post_POJO poj=new Post_POJO("sneha", "trainee");
		
		given()
		.body(poj)
		.contentType(ContentType.JSON)
		
		.when().post("/api/users")
		.then().log().all();

	}
	
}
