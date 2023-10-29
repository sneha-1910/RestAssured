package petstore;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class post {

@Test

public void case2()
{
	baseURI="https://petstore.swagger.io/v2/swagger.json";
	
	JSONObject jobj=new JSONObject();
	jobj.put("id", 101);
	jobj.put("id", 55);
	jobj.put("name", "puppy");
	
	given().body(jobj).contentType(ContentType.JSON)
	.when().post("/pet")
	.then().log().all();
}
	
@Test
public void upload_image()
{
	File image=new File("C:\\Users\\DELL\\Desktop\\Test yantra\\photos\\image.jpg");
	
	baseURI="https://petstore.swagger.io/v2/swagger.json";
	     
	Response res = given().multiPart("file",image)
	.when().post("/pet/{101}/uploadImage");
	
	System.out.println("Responses:"+ res.asString());
	System.out.println("statuscode:"+res.statusCode());
	
}
}
