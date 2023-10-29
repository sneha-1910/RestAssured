package crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	
	@Test
	public void get()
	{   
		baseURI="https://reqres.in";
		given().queryParams("page","2")
		.when().get("/api/users")
		.then().log().all();
		
	}
	
	
	
	
}
