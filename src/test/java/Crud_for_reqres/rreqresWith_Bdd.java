package Crud_for_reqres;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class rreqresWith_Bdd {

	@Test
	public void Post() 
	{
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "sonali");
		jobj.put("job","Traine");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
	   // .statusCode(201) or
		   .statusLine("HTTP/1.1 201 Created")
		.log()
		.all();	
	}
	
	@Test
	public void get() 
	{
		baseURI="https://reqres.in";
		
		when()
		.get("/api/users/2")
		
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
	
	@Test
	public void put()
	{
	baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "sonali");
		jobj.put("job","Traine");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/api/users/2")
		
		.then()
		.assertThat()
	    .statusCode(200)
	    .time(Matchers.lessThan(2399l),TimeUnit.MILLISECONDS)
		.log()
		.all();	
	}
	
	@Test
	public void patch()
	{
       baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "sonali");
		jobj.put("job","Traine");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.patch("/api/users/2")
		
		.then()
		.assertThat()
	    .statusCode(200)
	    .time(Matchers.lessThan(2399l),TimeUnit.MILLISECONDS)
		.log()
		.all();	
	}

	@Test
	public void Delete()
	{
		 baseURI="https://reqres.in";
		 
		when()
		.delete("/api/users/2")
		
		.then()
		.assertThat()
	    .statusCode(204)
	    .time(Matchers.lessThan(2399l),TimeUnit.MILLISECONDS)
		.log()
		.all();	
	}
	
}
