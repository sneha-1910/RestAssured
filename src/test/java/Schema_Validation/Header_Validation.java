package Schema_Validation;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class Header_Validation {

	@Test
	public void validate() 
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expected_statusLine="HTTP/1.1 200 ";
		String expected_vary="Access-Control-Request-Headers";
		String expected_contentType="application/json";
		String expected_pragma="no-cache";
		String expected_connection="keep-alive";

	   Response res = when().get("http://rmgtestingserver:8084/projects/TY_PROJ_76198");
	   
	   String statusLine=res.statusLine();
	   System.out.println(statusLine);
	   Assert.assertEquals(expected_statusLine, statusLine);
	   
	      Headers head = res.getHeaders();
	      System.out.println(head);
	 
	     String actual_ContentType=res.getHeader("Content-Type");
	    Assert.assertEquals(expected_contentType, actual_ContentType);
	     
		String actual_vary=res.getHeader("Vary");
		System.out.println(actual_vary);
		Assert.assertEquals(expected_vary, actual_vary);
		
		String actual_pragma=res.getHeader("Pragma");
		Assert.assertEquals(expected_pragma, actual_pragma);
		
		String actual_connection=res.getHeader("Connection");
		Assert.assertEquals(expected_connection, actual_connection);
				
	}	
}
