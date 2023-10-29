package Interview_practice;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Pojo.JsonFileReader;
import io.restassured.mapper.ObjectMapper;

import static io.restassured.RestAssured.*;

public class arrayOfobj extends JsonFileReader  {


	
@Test
public void arrayofobject()
{
	JSONObject jsonData = JsonFileReader.readdatafromJsonfile(".\\CreateProject.json") ; 
	  System.out.println(jsonData);
	  
	        
	  
	  
	  
}
	
	
	
	
	
	
}
