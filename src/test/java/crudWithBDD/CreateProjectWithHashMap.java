package crudWithBDD;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class CreateProjectWithHashMap {

@Test
	public void crp() {
        
      HashMap map =new HashMap();
      
      {
          map.put("createdBy", "Sneha");
          map.put("projectName", "19071997");
          map.put("status", "ongoing");
          map.put("teamSize", 1);
      }
      given()
      .body(map)
      .contentType(ContentType.JSON)
      
      .when()
      .post("http://rmgtestingserver:8084/addProject")
      
      .then()
      .assertThat()
      .contentType(ContentType.JSON)
      .statusCode(201)
      .log()
      .all();
      
         
	}        
	
}
