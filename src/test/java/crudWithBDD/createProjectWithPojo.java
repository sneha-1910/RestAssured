package crudWithBDD;

import Pojo.Pojoclass_createProject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class createProjectWithPojo {

	@Test
	public void crp()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		Pojoclass_createProject pcp=new Pojoclass_createProject("sneha", "19100", "ongoing", 16);
		
		given()
		.body(pcp)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(4000l),TimeUnit.MILLISECONDS)
		.statusCode(201)
		.log()
		.all();
		
		
		
	}
}
