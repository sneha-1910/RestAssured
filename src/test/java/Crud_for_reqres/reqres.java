package Crud_for_reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class reqres {

	@Test
	public void create() 
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "sneha");
		jobj.put("job", "leader");
	
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response res = reqs.post("https://reqres.in/api/users");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.prettyPeek());	
	}
	
	@Test
	public void get() 
	{
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.prettyPeek());
		
	}
	
	@Test
	public void Put()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "sonu");
		jobj.put("job", "zion resident");
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response res = reqs.put("https://reqres.in/api/users/2");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.prettyPeek());
		
	}
	
	@Test
	public void patch() 
	{
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Paaru");
		jobj.put("job", "zion resident");
		
		RequestSpecification reqs = RestAssured.given();
		reqs.body(jobj);
		reqs.contentType(ContentType.JSON);
		
		Response res = reqs.put("https://reqres.in/api/users/2");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.prettyPeek());
	}
	
	@Test
	public void Delete() 
	{
		Response res = RestAssured.delete("https://reqres.in/api/users/2");
		System.out.println(res.contentType());
		System.out.println(res.statusCode());
	}
	
}
