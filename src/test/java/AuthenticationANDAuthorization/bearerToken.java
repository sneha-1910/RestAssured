package AuthenticationANDAuthorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class bearerToken {

	@Test
	public void bearer() 
	{
		baseURI="https://api.github.com";
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "snehaaaa");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
}
	
	
@Test
public void get() 
{
	baseURI="https://api.github.com";
	
	given().auth().oauth2("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")
	.when().get("")
	.then().log().all();
}
	
	
	
	
	
}
