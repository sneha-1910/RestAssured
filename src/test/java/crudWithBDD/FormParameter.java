package crudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {

	@Test
	public void post()
	{
		baseURI="https://reqres.in";
		
		given().formParam("name","morpheus")
		      .formParam("job","leader").contentType(ContentType.JSON)
		 .when().post("/api/users")
		 .then().log().all();
	}
	
	
	
	
}
