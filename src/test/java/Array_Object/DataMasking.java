package Array_Object;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class DataMasking {

	@Test
	public void Data()
	{
		  Random ran=new Random();
		  int random=ran.nextInt(1000);
		  
		JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "ss");
		 jobj.put("projectName", "tyss");
		 jobj.put("ststus", "ongoing");
		 jobj.put("teamSize", 4);
		 
		 given().config(RestAssured.config.logConfig(LogConfig.logConfig()
				 .blacklistHeader("Content-Type")))
		 .body(jobj)
		 .contentType(ContentType.JSON)
	
		 
		 .when().post("http://rmgtestingserver:8084/addProject")
		 .then().assertThat().log().all();
		 
	}
	
}
