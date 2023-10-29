package Crud_for_reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class pathparam_queryparam {
   
	@Test
	public void get()
	{   
		baseURI="https://reqres.in";
		given().pathParam("us", "users").queryParams("page","2")
		.when().get("/api/{us}")
		.then().log().all();
		
	}
	
	
	
	
	
}
