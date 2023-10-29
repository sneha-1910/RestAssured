package Interview_practice;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class resres_interview_practice {

	@Test
	public void case11() throws JsonProcessingException, IOException
	{
		Response res = when().get("https://reqres.in/api/users/2");
		 String res_body = res.getBody().prettyPrint();
		 
		 ObjectMapper map=new ObjectMapper();
		 
			JsonNode jsonNode = map.readTree(res_body);
				
				boolean ab=jsonNode.isArray();
	 
	}
	
	
	
	
	
	
	
}
