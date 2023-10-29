package crudWithBDD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithFile {

	@Test
	public void crp() {
		 
		baseURI="http://rmgtestingserver";
		port=8084;
	
		File fli=new File(".//CreateProject.json");
		
		given()
		.body(fli)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log()
		.all();
		
		

	}

}
