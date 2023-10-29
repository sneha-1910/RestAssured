package Schema_Validation;

import static io.restassured.RestAssured.when;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class json_Schema {
 
	
	@Test
	public void test() 
	{
		File file = new File("./schema.json");
		when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file))
		.log().all();
		System.out.println("validated");
		
	}
	
	
	//url=https://jsonformatter.org/json-to-jsonschema
	
}
