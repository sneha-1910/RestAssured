package Reqs_Spec_builder_REs_spec_builder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Pojo.Pojoclass_createProject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class create_project {

	 @Test
	 public void test()
	 {
		 
		  Pojoclass_createProject pcp = new Pojoclass_createProject("sneha", "tyss", "ongoing", 5);
		 
		           RequestSpecification request = new RequestSpecBuilder()
		               .setBaseUri("http://rmgtestingserver:8084")
		               .setContentType(ContentType.JSON).build();
		         
		         
		      ResponseSpecification response = new ResponseSpecBuilder()
		                     .expectContentType(ContentType.JSON)
		                     .expectStatusCode(201).build();
		         
		       given()
		       .spec(request).body(pcp)
		       .when().post("/addProject")
		       .then().spec(response).log().all();
		         
		 
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
