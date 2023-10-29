package Interview_practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Zopsmart {

	@Test
	public void case1()
	{
		JSONObject jobj=new JSONObject();
		{
			jobj.put("name", "sneha");
			jobj.put("mail", "sneha@gmail.com");
		}
		
	      given().body(jobj).contentType(ContentType.JSON)
	      .cookie("key", "value", "value")
	      .cookie("token")
	      .cookies(jobj);
	      
	     
	}
	
	@Test
	public void case2()
	{ 	
//	JSONObject jobj=new JSONObject();
//		{
//			jobj.put("name", "sneha");
//			jobj.put("job", "Nothing");
//		}
//		
//		given().body(jobj).contentType(ContentType.JSON)
//		.when().post("https://reqres.in/api/users")
//		.then().log().all();
//		
		Response res = when().get("https://reqres.in/api/users?page=2");
		
		int ID = res.jsonPath().get("data[1].id");
		
		   given().pathParam("idd", ID)
		   .when().get("https://reqres.in/api/users/{idd}")
		   .then().log().all();
		
		
		
	}
	
	
	
	
}
