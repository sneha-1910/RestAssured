package AuthenticationANDAuthorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_auth {

	@Test
	public void basic() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202).log().all();
	
	}	
	
	
	@Test
	public void preemptive()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when().get("/login")
		
		.then().statusCode(202).log().all();
	}
	
	
	@Test
	public void digestive() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().auth().digest("rmgyantra", "rmgy@9999")
		
		.when().get("/login")
		.then().statusCode(202).log().all();
		
	}

}









