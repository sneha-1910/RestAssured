package Array_Object;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;



public class Validation {

	
	@Test
	public void ArrayOfObject() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects")
		.then().assertThat().body("", Matchers.instanceOf(List.class)).log().all();
		
				
	}
	
	@Test
	public void SingleObject()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when().get("/projects/TY_PROJ_9859")
		.then().assertThat().body("", Matchers.instanceOf(Map.class)).log().all();
	}
	
	
	
	
	
	
	
	
	
}
