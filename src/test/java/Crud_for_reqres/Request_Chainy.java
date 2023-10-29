package Crud_for_reqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Request_Chainy {

	@Test
	public void getAllusers()
	{
		
		baseURI="https://reqres.in";
	
		Response res = when().get("/api/users?page=2");
		int ID = res.jsonPath().get("data[2].id");
		//res.then().log().all();
		
		when().get("/api/users/"+ID)
		.then().log().all();
		
	}
	
	@Test
	public void reqch() 
	{
		baseURI="https://reqres.in";
		
		JSONObject jobj = new JSONObject();
		jobj.put("email", "sneha@19");
		jobj.put("password", "s!19");
		
		Response res = given().body(jobj).contentType(ContentType.JSON)
		.when()
		.post("/api/register");
		int id=res.jsonPath().get("id");
		
		
		when().get("/api/unknown"+id)
		.then().log().all();
		   
		
	}
}
