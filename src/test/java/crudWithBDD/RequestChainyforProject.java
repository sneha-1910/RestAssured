package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class RequestChainyforProject {


	
	@Test
	public void post()
	{
		JavaUtility ju=new JavaUtility();
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "sonusneha");
		jobj.put("projectName", "123467"+ju.getRandomNo());
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 12);
		
		Response res =  given()
		    .body(jobj)
		    .contentType(ContentType.JSON)
		    
		.when().post("/addProject");
		
		    
       String proID=res.jsonPath().get("projectId");
       System.out.println(proID);
       res.then().statusCode(201).log().all();
       
    //   when().get("/projects/"+proID)
    //   .then().statusCode(200).log().all();
       
       //using path parameter
       
       given().pathParam("Pid", proID)
       .when().get("/projects/{Pid}")
       .then().log().all();
       
  
	}
	 

	
	
}
